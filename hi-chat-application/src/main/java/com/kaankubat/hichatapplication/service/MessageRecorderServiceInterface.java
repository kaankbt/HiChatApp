package com.kaankubat.hichatapplication.service;

import java.util.List;

import com.kaankubat.hichatapplication.model.MessageModel;

public interface MessageRecorderServiceInterface {

    void save(String sender, String receiver, String messageContent);

    List<MessageModel> findAllByReceiverName(String receiverName);
}