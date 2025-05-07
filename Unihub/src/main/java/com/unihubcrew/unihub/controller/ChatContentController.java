package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.model.ChatContent;
import com.unihubcrew.unihub.service.ChatContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatContent")
public class ChatContentController {

    @Autowired
    private ChatContentService chatContentService;

    @GetMapping("/id/{id}")
    public ChatContent getChatContentById(@PathVariable Long id) {
        return chatContentService.getChatContentById(id);
    }

    @GetMapping("/all")
    public List<ChatContent> getAllChatContents() {
        return chatContentService.getAllChatContents();
    }

    @PostMapping("/add")
    public void addChatContent(@RequestBody ChatContent chatContent) {
        chatContentService.addChatContent(chatContent);
    }

    @PostMapping("/update")
    public void updateChatContent(@RequestBody ChatContent chatContent) {
        chatContentService.updateChatContent(chatContent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChatContent(@PathVariable Long id) {
        chatContentService.deleteChatContent(id);
    }
}
