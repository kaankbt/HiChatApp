package com.kaankubat.hichatapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankubat.hichatapplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String mail);
	User findByUserName(String name);
}
