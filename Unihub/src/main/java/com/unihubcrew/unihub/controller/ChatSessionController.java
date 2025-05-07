package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.model.ChatSession;
import com.unihubcrew.unihub.service.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatSession")
public class ChatSessionController {

    @Autowired
    private ChatSessionService chatSessionService;

    @GetMapping("/id/{id}")
    public ChatSession getChatSessionById(@PathVariable Long id) {
        return chatSessionService.getChatSessionById(id);
    }

    @GetMapping("/all")
    public List<ChatSession> getAllChatSessions() {
        return chatSessionService.getAllChatSessions();
    }

    @PostMapping("/add")
    public void addChatSession(@RequestBody ChatSession chatSession) {
        chatSessionService.addChatSession(chatSession);
    }

    @PostMapping("/update")
    public void updateChatSession(@RequestBody ChatSession chatSession) {
        chatSessionService.updateChatSession(chatSession);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChatSession(@PathVariable Long id) {
        chatSessionService.deleteChatSession(id);
    }
}
