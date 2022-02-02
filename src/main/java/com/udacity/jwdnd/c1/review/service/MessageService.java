package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    ChatMessageMapper chatMessageMapper;

    public MessageService(ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
        System.out.println("Message Service created");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName(chatForm.getUserName());
        switch (chatForm.getMessageType()) {
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }

        this.chatMessageMapper.saveMessage(chatMessage);
    }

    public List<ChatMessage> getMessages() {
        return this.chatMessageMapper.getMessages();
    }
}
