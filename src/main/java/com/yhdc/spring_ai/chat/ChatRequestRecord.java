package com.yhdc.spring_ai.chat;

import java.util.Objects;

public record ChatRequestRecord(String modelType, String prompt) {

    public ChatRequestRecord {
        Objects.requireNonNull(modelType, "Model type must not be null");
        Objects.requireNonNull(prompt, "Prompt must not be null");
    }

}
