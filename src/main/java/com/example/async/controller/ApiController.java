package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {


    private final AsyncService asyncService; // lombok import안해서 생성자 생성으로 진행

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }


    @GetMapping("/hello") // http://localhost:8080/api/hello
    public CompletableFuture hello(){
    // CompletableFuture : 다른 쓰레드에서 실행시키고 결과를 반환받는 형태, 별도의 스레드로 다른 작업을 계속할 수 있다

        log.info("completable future init");
        return asyncService.run();

    }

}
