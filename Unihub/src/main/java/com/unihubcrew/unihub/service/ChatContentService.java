package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.ChatContentMapper;
import com.unihubcrew.unihub.model.ChatContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatContentService {
    @Autowired
    private ChatContentMapper chatcontentMapper;

    public ChatContent getChatContentById(Long id) {
        return chatcontentMapper.getChatContentById(id);
    }

    public List<ChatContent> getAllChatContents() {
        return chatcontentMapper.getAllChatContents();
    }

    public void addChatContent(ChatContent chatcontent) {
        chatcontentMapper.addChatContent(chatcontent);
    }

    public void updateChatContent(ChatContent chatcontent) {
        chatcontentMapper.updateChatContent(chatcontent);
    }

    public void deleteChatContent(Long id) {
        chatcontentMapper.deleteChatContent(id);
    }
}
