package com.demo.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.RequestBody;
import io.vertx.ext.web.Router;
import org.springframework.stereotype.Component;

//@Component
//public class MainVerticle extends AbstractVerticle {
//
//  @Override
//  public void start(Promise<Void> startPromise) throws Exception {
//    Router router = Router.router(vertx);
//
//    router.get("/api/data").handler(ctx -> {
//      ctx.response().putHeader("content-type", "application/json")
//        .end("{\"status\": \"Vert.x xử lý, Spring quản lý!\"}");
//    });
//
//    router.post("/api/sender").handler(ctx -> {
//      RequestBody body = ctx.body();
//      User pojo = body.asPojo(User.class);
//      IO.println(pojo.name() + " " + pojo.age());
//      ctx.response()
//        .putHeader("content-type", "application/json")
//        .end(pojo.toString());
//    });
//    vertx.createHttpServer().requestHandler(router)
//      .listen(8008)
//      .onSuccess(server -> {
//      startPromise.complete();
//    }).onFailure(startPromise::fail);
//  }
//  public record User(String name, String age){
//    @Override
//    public String toString() {
//      return "User{" +
//        "name='" + name + '\'' +
//        ", age='" + age + '\'' +
//        '}';
//    }
//  }
//}
