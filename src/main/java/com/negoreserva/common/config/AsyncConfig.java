package com.negoreserva.common.config;

import com.negoreserva.common.variable.AsyncBeanVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Bean(name = AsyncBeanVariable.FORGET_PASSWORD)
    public Executor smsForgetPasswordExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    @Bean(name = AsyncBeanVariable.CREATE_ACCOUNT_OTP_VERIFICATION)
    public Executor smsCreateAccountOtpVerificationExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> log.error("[Async] Erro não tratado em {}: {}", method.getName(), ex.getMessage());
    }
}