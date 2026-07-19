package com.demo.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;


public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Router router = Router.router(vertx);
    router.get("/api/data").handler(ctx -> {
      ctx.response().putHeader("content-type", "application/json")
        .end("{\"status\": \"Vert.x xử lý, Spring quản lý!\"}");
    });

    vertx.createHttpServer().requestHandler(router)
      .listen(8008)
      .onSuccess(server -> {
      startPromise.complete();
    }).onFailure(startPromise::fail);
  }

}
