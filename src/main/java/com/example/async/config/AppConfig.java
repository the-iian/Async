package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
public class AppConfig { // 직접 쓰레드 생성하기 (쓰레드 동작방식)

    @Bean("async-thread")
    public Executor asyncThread(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setMaxPoolSize(100); // 5. 최대사이즈 100개까지 진행되는 형태
        threadPoolTaskExecutor.setCorePoolSize(10); // 1. pool에 10개가 다 차게되면, 3. 다시 10개가 차서 20개가 되면
        threadPoolTaskExecutor.setQueueCapacity(10); // 2. Queue에 10개가 이동하게되고  4. 큐에 10개가 추가로 저장되고
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");

        return threadPoolTaskExecutor;
    }
}
