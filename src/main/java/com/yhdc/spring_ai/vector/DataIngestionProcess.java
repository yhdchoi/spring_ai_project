package com.yhdc.spring_ai.vector;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.reader.pdf.ParagraphPdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataIngestionProcess implements CommandLineRunner {

    private final VectorStore vectorStore;

    @Value("classpath:/documents/weekly_market_recap.pdf")
    private Resource marketPDF;

    /**
     * Load the data to the PgVector
     *
     * @param args
     * @implNote Runs on the start of the Application
     * @implSpec Feeds PDF documents and splits them into tokens then save them to Database
     */
    @Override
    public void run(String... args) throws Exception {
        var pdfReader = new ParagraphPdfDocumentReader(marketPDF);
        TextSplitter textSplitter = new TokenTextSplitter();
        vectorStore.accept(textSplitter.apply(pdfReader.get()));
        log.info("VectorStore loaded with data...");
    }
}
