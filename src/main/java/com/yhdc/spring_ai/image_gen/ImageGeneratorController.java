package com.yhdc.spring_ai.image_gen;

import com.yhdc.spring_ai.chat.OpenAiChatModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageGeneratorController {

    private final ImageService imageService;

    public ImageGeneratorController(OpenAiChatModelService openAiChatModelService, ImageService imageService) {
        this.imageService = imageService;
    }


    /**
     * Generate image
     *
     * @param prompt
     * @apiNote
     */
    @GetMapping("/open-ai/gen-image")
    public ResponseEntity<?> imageGenerator(@RequestParam(value = "prompt") String prompt,
                                            @RequestParam(value = "number", required = false, defaultValue = "1") String number,
                                            @RequestParam(value = "height", required = false, defaultValue = "1024") String height,
                                            @RequestParam(value = "width", required = false, defaultValue = "1024") String width) {
        return imageService.generateImage(prompt,
                Integer.parseInt(number),
                Integer.parseInt(height),
                Integer.parseInt(width));
    }

}
