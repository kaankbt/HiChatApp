package com.kaankubat.hichatapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankubat.hichatapplication.model.MessageRecorderModel;

@Repository
public interface MessageRecorderRepository extends JpaRepository<MessageRecorderModel, Long>{
	List<MessageRecorderModel> findAllByReceiverName(String receiverName);
}
