package com.gemini.ai.service.service;

import com.gemini.ai.service.dto.ChatResponseDto;

public interface ChatService {

    ChatResponseDto askQuestion(String message);
}