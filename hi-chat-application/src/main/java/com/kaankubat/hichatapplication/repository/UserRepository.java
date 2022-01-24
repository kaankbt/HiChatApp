package com.kaankubat.hichatapplication.repository;


import com.kaankubat.hichatapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String mail);
    User findByUserName(String name);
}
