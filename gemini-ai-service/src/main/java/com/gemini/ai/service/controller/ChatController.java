package com.gemini.ai.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.ai.service.dto.ChatRequestDto;
import com.gemini.ai.service.dto.ChatResponseDto;
import com.gemini.ai.service.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/ask")
    public ChatResponseDto ask(@RequestBody ChatRequestDto request) {
        return chatService.askQuestion(request.getMessage());
    }
}