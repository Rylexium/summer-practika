package com.practice.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.app.feign.GiphyFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiphyService {

    private final GiphyFeignClient clientGiphy;

    @Value("33l4C2oYmBUCDXn2flrmiRBr12RhkmBP")
    private String key;

    public String getGif(String gifType) {
        JsonNode parent = null;
        try {
            parent = new ObjectMapper().readTree(clientGiphy.getGif(gifType, key, "g"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String gifUrl = parent.get("data")
                .get("images")
                .get("fixed_height")
                .get("url").asText();
        return gifUrl;
    }
}