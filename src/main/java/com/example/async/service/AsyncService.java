package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async // 비동기로 동작
    public CompletableFuture run(){

        return new AsyncResult(hello()).completable();
    }

    public String hello() {

        // 이렇게 코딩하진않지만 thread 확인용
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "async hello";
    }
}
