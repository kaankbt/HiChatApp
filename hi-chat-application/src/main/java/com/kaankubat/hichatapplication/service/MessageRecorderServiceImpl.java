package com.kaankubat.hichatapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankubat.hichatapplication.model.MessageRecorderModel;
import com.kaankubat.hichatapplication.repository.MessageRecorderRepository;

@Service
public class MessageRecorderServiceImpl implements MessageRecorderServiceInterface{
	
	private final MessageRecorderRepository messageRecorderRepo;

	@Autowired
	public MessageRecorderServiceImpl(MessageRecorderRepository messageRecorderRepo) {
		this.messageRecorderRepo = messageRecorderRepo;
	}
	
	@Override
	public void save(String sender, String receiver, String messageContent) {
		MessageRecorderModel messageEntity = new MessageRecorderModel();
		messageEntity.setSenderName(sender);
		messageEntity.setReceiverName(receiver);
		messageEntity.setMessageContent(messageContent);
		messageRecorderRepo.save(messageEntity);
	}

	@Override
	public List<MessageRecorderModel> findAllByReceiverName(String receiverName) {
		List<MessageRecorderModel> myMessages = messageRecorderRepo.findAllByReceiverName(receiverName);
		return myMessages;
	}
	
	
	

}
