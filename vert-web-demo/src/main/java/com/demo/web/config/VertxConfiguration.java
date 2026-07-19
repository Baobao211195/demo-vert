package com.demo.web.config;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.WorkerExecutor;
import io.vertx.ext.web.client.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertxConfiguration {

    @Bean(destroyMethod = "close")
    Vertx vertx() {
        VertxOptions options = new VertxOptions()
              .setEventLoopPoolSize(Runtime.getRuntime().availableProcessors())
              .setWorkerPoolSize(64)
              .setPreferNativeTransport(true);
        return Vertx.vertx(options);
    }

    @Bean
    WebClient webClient(Vertx vertx) {
        return WebClient.create(vertx);
    }

    @Bean
    WorkerExecutor sharedWorkerExecutor(Vertx vertx) {
        return vertx.createSharedWorkerExecutor(
              "shared-worker",
              32
        );
    }

}
