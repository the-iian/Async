package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {


    private final AsyncService asyncService; // lombok import안해서 생성자 생성으로 진행

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }


    @GetMapping("/hello") // http://localhost:8080/api/hello
    public String hello(){

        asyncService.hello();

        log.info("method end");

        return "hello";

    }

}
