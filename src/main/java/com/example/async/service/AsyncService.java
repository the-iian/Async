package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    /* 아래 CompletableFuture방식은 의미가 없지만 웹 MVC에서 사용하는 패턴 경험해보기

       CompletableFuture을 잘 사용하는 방법

      여러개의 API 3, 4개를 동시에 전송하고 결과를 join해서 받을 때 사용하는 게 좋은 형태이다
      단계별로 request가 나가는게 아닌, 한번에 여러개 request가 나가고, 그 결과를 모아서 리턴할 때
      일반적인 메소드내에서 CompletableFuture를 여러개 만든 다음에 전송시키고 합쳐서 응답내려주는게 제일 좋은 방안 */

    @Async("async-thread") // 원하는 쓰레드의 이름을 지정하여 비동기 사용
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
