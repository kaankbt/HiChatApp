package com.kaankubat.hichatapplication.service;

import java.util.List;

import com.kaankubat.hichatapplication.model.MessageRecorderModel;

public interface MessageRecorderServiceInterface {
	
	void save(String sender, String receiver, String messageContent);
	
	List<MessageRecorderModel> findAllByReceiverName(String receiverName);
}
