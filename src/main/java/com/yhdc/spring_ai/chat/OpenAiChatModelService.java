package com.yhdc.spring_ai.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Deprecated
@Slf4j
@Service
public class OpenAiChatModelService {

    private final ChatModel chatModel;

    public OpenAiChatModelService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * Chat response
     *
     * @param chatRequestRecord
     * @implNote
     * @implSpec
     */
    public ResponseEntity<?> getChatResponse(ChatRequestRecord chatRequestRecord) {

        final String prompt = chatRequestRecord.prompt();

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
        final String mediaName = chatResponse.getResult().getOutput().getMedia().getFirst().getName();

        HashMap<String, Object> response = new HashMap<>();
        response.put("Response", responseText);
        log.info("Response: {}", responseText);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    private ChatResponseDto getChatResponseDto(Generation generation) {
        ChatResponseDto chatResponseDto = new ChatResponseDto();
        chatResponseDto.setTextResponse(generation.getOutput().getText());
        return chatResponseDto;
    }

}
