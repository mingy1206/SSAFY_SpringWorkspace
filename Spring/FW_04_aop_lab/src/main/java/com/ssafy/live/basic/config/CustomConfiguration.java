package com.ssafy.live.basic.config;

import java.util.concurrent.Executor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.ssafy.live.basic.bean.HeavyWorkBean;
import com.ssafy.live.basic.bean.PointcutTestBean;

@Configuration
@EnableAsync //비동기를 위한 @Async
@EnableCaching // cache 동작 추가
public class CustomConfiguration {

    @Bean
    PointcutTestBean pointcutTestBean() {
        return new PointcutTestBean();
    }

    @Bean
    HeavyWorkBean heavyWorkBean() {
        return new HeavyWorkBean(pointcutTestBean());
    }

    // @Bean // 커스텀 SimpleAsyncTaskExecutor 등록
    public TaskExecutor simpleTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    // @Bean // 커스텀 ThreadPoolTaskExecutor 등록
    public TaskExecutor customTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 기본 스레드 수
        executor.setQueueCapacity(25); // 대기열 용량
        executor.setMaxPoolSize(10); // 최대 스레드 수 : 대기열을 다 채웠을 때 확장 가능한 스레드 수
        return executor;
    }


}
