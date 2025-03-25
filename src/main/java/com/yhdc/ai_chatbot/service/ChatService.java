package com.yhdc.ai_chatbot.service;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class ChatService {

    private static final Logger log = LoggerFactory.getLogger(ChatService.class);
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * Chat response
     *
     * @param prompt
     * @implNote
     * @implSpec
     */
    public ResponseEntity<?> getResponseCustom(String prompt) {

        ChatResponse chatResponse = chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o-mini")
                                .temperature(0.4)
                                .build()
                ));

        log.info("ChatResponse: {}", chatResponse.toString());
        final String responseText = chatResponse.getResult().getOutput().getText();

        HashMap<String, Object> response = new HashMap<>();
        response.put("Response", responseText);
        log.info("Response: {}", responseText);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
