package com.demo.web;

import com.demo.web.config.CustomerHttpClient;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringVertxApplication implements CommandLineRunner {

//    @Autowired
//    private MainVerticle mainVerticle; // Inject Verticle đã cấu hình ở bước 3
    private final CustomerHttpClient customerHttpClient;

  public SpringVertxApplication(CustomerHttpClient customerHttpClient) {
    this.customerHttpClient = customerHttpClient;
  }

  static void main(String[] args) {
        SpringApplication.run(SpringVertxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      customerHttpClient.getCustomer()
        .onComplete(result -> IO.println(result.result()))
        .onFailure(err -> IO.println(err.getMessage()));
//        Vertx vertx = Vertx.vertx();
//        vertx.deployVerticle(mainVerticle)
//          .onSuccess(id -> System.out.println("Deploy Verticle thành công với ID: " + id))
//          .onFailure(err -> System.err.println("Lỗi deploy: " + err.getMessage()));
    }
}
