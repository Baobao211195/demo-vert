package com.demo.web.config;

import io.vertx.core.Future;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import org.springframework.stereotype.Service;

@Service
public class CustomerHttpClient {

    private final WebClient webClient;

    public CustomerHttpClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Future<String> getCustomer() {
        return webClient
              .getAbs("https://jsonplaceholder.typicode.com/users/1")
              .send()
              .map(HttpResponse::bodyAsString);
    }
}
