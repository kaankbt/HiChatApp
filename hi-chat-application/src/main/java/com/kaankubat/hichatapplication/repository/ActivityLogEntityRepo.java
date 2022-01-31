package com.kaankubat.hichatapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankubat.hichatapplication.model.ActivityLogModel;

@Repository
public interface ActivityLogEntityRepo extends JpaRepository<ActivityLogModel,Long>{
	
}
