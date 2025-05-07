package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.ChatSessionMapper;
import com.unihubcrew.unihub.model.ChatSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatSessionService {
    @Autowired
    private ChatSessionMapper chatSessionMapper;

    public ChatSession getChatSessionById(Long id) {
        return chatSessionMapper.getChatSessionById(id);
    }

    public List<ChatSession> getAllChatSessions() {
        return chatSessionMapper.getAllChatSessions();
    }

    public void addChatSession(ChatSession chatSession) {
        chatSessionMapper.addChatSession(chatSession);
    }

    public void updateChatSession(ChatSession chatSession) {
        chatSessionMapper.updateChatSession(chatSession);
    }

    public void deleteChatSession(Long id) {
        chatSessionMapper.deleteChatSession(id);
    }
}
