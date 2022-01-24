package com.kaankubat.hichatapplication.repository;

import com.kaankubat.hichatapplication.model.ActivityLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ActivityLogModelRepo extends JpaRepository<ActivityLogModel,Long>{

}