package com.practice.app.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "giphy", url="api.giphy.com/v1/gifs/random"
)
public interface GiphyFeignClient {

    @GetMapping
    String getGif(@RequestParam String tag
            , @RequestParam String api_key
            , @RequestParam String rating
    );


}
