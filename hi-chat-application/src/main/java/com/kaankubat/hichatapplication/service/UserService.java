package com.kaankubat.hichatapplication.service;

import com.kaankubat.hichatapplication.enums.ActivityType;
import com.kaankubat.hichatapplication.model.ActivityLogModel;
import com.kaankubat.hichatapplication.model.BlockModel;
import com.kaankubat.hichatapplication.model.User;
import com.kaankubat.hichatapplication.repository.ActivityLogModelRepo;
import com.kaankubat.hichatapplication.repository.BlockRepository;
import com.kaankubat.hichatapplication.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserService implements UserServiceInterface {

    private final UserRepository userRepo;
    private final ActivityLogModelRepo activityLogEntityRepo;
    private final BlockRepository blockedUserRepo;

    public UserService(UserRepository userRepo, ActivityLogModelRepo activityLogEntityRepo, BlockRepository blockedUserRepo) {
        this.userRepo = userRepo;
        this.activityLogEntityRepo = activityLogEntityRepo;
        this.blockedUserRepo = blockedUserRepo;
    }


    @Override
    public String save(User user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassWord());
        ActivityLogModel entity = new ActivityLogModel();
        user.setPassWord(encodedPassword);
        try {
            userRepo.save(user);
        } catch (Exception e) {
            entity.setActivity(ActivityType.INVALID_REGISTER);
            entity.setUserName("---");
            activityLogEntityRepo.save(entity);
            throw new Exception("Invalid Register");
        }

        entity.setUserName(user.getUserName());
        entity.setActivity(ActivityType.REGISTER);
        activityLogEntityRepo.save(entity);
        return user.getUserName();
    }

    @Override
    public Boolean block(String angryName, String blockedName) {
        User angry = userRepo.findByUserName(angryName);
        User blocked = userRepo.findByUserName(blockedName);
        if (angry.getId() != null && blocked.getId() != null) {
            BlockModel blockModel = new BlockModel();
            blockModel.setAngryId(angry.getId());
            blockModel.setBlockedId(blocked.getId());
            blockedUserRepo.save(blockModel);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> listUsers = userRepo.findAll();
        return listUsers;
    }

    @Override
    public User findByEmail(String mail) {
        User user = userRepo.findByEmail(mail);
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        User user = userRepo.findByUserName(userName);
        return user;
    }

    @Override
    public Set<String> findAllByName() {
        List<User> listUsers = userRepo.findAll();
        Set<String> response = new HashSet<String>();
        listUsers.forEach(user -> {
            String name = user.getUserName();
            response.add(name);
        });

        return response;
    }

    @Override
    public Boolean blockControl(String angryName, String blockedName) {
        User angry = userRepo.findByUserName(angryName);
        User blocked = userRepo.findByUserName(blockedName);
        List<BlockModel> listOfBlock = blockedUserRepo.findAllByAngryId(angry.getId());
        ArrayList<Long> blockedIds = new ArrayList<Long>();
        int loop = listOfBlock.size();
        for (int flag = 0; flag < loop; flag++) {
            blockedIds.add(listOfBlock.get(flag).getBlockedId());
        }
        if (blockedIds.contains(blocked.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean unblock(String angryName, String blockedName) {
        User angry = userRepo.findByUserName(angryName);
        User blocked = userRepo.findByUserName(blockedName);

        if (angry.getId() != null && blocked.getId() != null) {
            try {
                blockedUserRepo.unblock(angry.getId(), blocked.getId());
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

}