package com.kaankubat.hichatapplication.repository;

import com.kaankubat.hichatapplication.model.MessageRecorderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<MessageRecorderModel, Long> {
    List<MessageRecorderModel> findAllByReceiverName(String receiverName);
}