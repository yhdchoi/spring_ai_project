package com.yhdc.spring_ai.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final OpenAiChatService openAiChatService;
    private final AnthropicChatService anthropicChatService;

    @GetMapping("/open-ai/chat")
    public String openAiChatResponse(@RequestParam String prompt) {
        return openAiChatService.chat(prompt);
    }

    @GetMapping("/anthropic/chat")
    public String claudeChatResponse(@RequestParam String prompt) {
        return anthropicChatService.chat(prompt);
    }

}
