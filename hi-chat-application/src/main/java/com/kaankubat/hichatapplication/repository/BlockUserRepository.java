package com.kaankubat.hichatapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaankubat.hichatapplication.model.BlockUserModel;

@Repository
public interface BlockUserRepository extends JpaRepository<BlockUserModel,Long>{
	List<BlockUserModel> findAllByAngryId(Long angryId);
	
	@Transactional
	@Modifying
	@Query("delete from BlockUserModel b where b.angryId = :angryId and b.blockedId = :blockedId")
	void unblock(Long angryId, Long blockedId);
	
}
