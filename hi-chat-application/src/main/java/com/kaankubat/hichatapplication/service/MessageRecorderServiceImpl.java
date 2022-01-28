package com.kaankubat.hichatapplication.service;

import com.kaankubat.hichatapplication.model.MessageRecorderModel;
import com.kaankubat.hichatapplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageRecorderServiceImpl implements MessageRecorderServiceInterface{

    private final MessageRepository messageRecorderRepo;

    @Autowired
    public MessageRecorderServiceImpl(MessageRepository messageRecorderRepo) {
        this.messageRecorderRepo = messageRecorderRepo;
    }

    @Override
    public void save(String sender, String receiver, String messageContent) {
        MessageRecorderModel messageModel = new MessageRecorderModel();
        messageModel.setSenderName(sender);
        messageModel.setReceiverName(receiver);
        messageModel.setMessageContent(messageContent);
        messageRecorderRepo.save(messageModel);
    }

    @Override
    public List<MessageRecorderModel> findAllByReceiverName(String receiverName) {
        List<MessageRecorderModel> myMessages = messageRecorderRepo.findAllByReceiverName(receiverName);
        return myMessages;
    }
}