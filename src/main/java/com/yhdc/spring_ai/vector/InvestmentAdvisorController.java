package com.yhdc.spring_ai.vector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InvestmentAdvisorController {

    private final ChatClient chatClient;

    /**
     * Constructor
     *
     * @param builder
     * @param vectorStore
     * @apiNote Builds ChatClient with Advisor
     */
    public InvestmentAdvisorController(ChatClient.Builder builder, PgVectorStore vectorStore) {
        this.chatClient = builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    /**
     * Prompt Request
     *
     * @param prompt
     */
    @GetMapping("/adv")
    public String advisorCtl(@RequestParam String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
