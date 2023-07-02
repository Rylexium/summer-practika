package com.practice.app.controller;

import com.practice.app.service.GiphyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequiredArgsConstructor
public class GiphyController {

    private final GiphyService giphyService;

    @GetMapping("/")
    public ResponseEntity<String> test(@RequestParam(value = "param", required = false) String param) {
        return ResponseEntity.ok("test " + param);
    }

    @GetMapping("/shell")
    public ResponseEntity<Object> shell(@RequestParam(value = "cmd", required = false) String cmd) throws IOException {

        return ResponseEntity.ok("ok");
    }

    private void sync(InputStream in, OutputStream out) throws IOException
    {
        while (in.available() > 0)
        {
            out.write(in.read());
            out.flush();
        }
    }

    @GetMapping("/gif")
    public ResponseEntity<String> getGif(@RequestParam(value = "tag", required = false) String tag) {
        return ResponseEntity.ok(giphyService.getGif(tag));
    }
}