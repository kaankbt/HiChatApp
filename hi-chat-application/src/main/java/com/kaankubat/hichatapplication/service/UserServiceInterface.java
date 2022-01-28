package com.kaankubat.hichatapplication.service;

import com.kaankubat.hichatapplication.model.User;

import java.util.List;
import java.util.Set;

public interface UserServiceInterface {

    String save(User user) throws Exception;

    Boolean block(String angry, String blocked);

    Boolean unblock(String angry, String blocked);

    Boolean blockControl(String angry, String blocked);

    List<User> findAll();

    User findByEmail(String mail);

    User findByUserName(String userName);

    Set<String> findAllByName();
}