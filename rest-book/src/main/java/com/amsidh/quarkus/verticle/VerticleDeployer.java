package com.amsidh.quarkus.verticle;


import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.vertx.core.AbstractVerticle;
import io.vertx.mutiny.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class VerticleDeployer {

    public void init(@Observes StartupEvent startupEvent, Vertx vertx, Instance<AbstractVerticle> verticles) {
        verticles.forEach(v -> {
                    log.info("Deploying Verticle {}", v.getClass().getName());
                    vertx.deployVerticle(v).await().indefinitely();
                }
        );
    }
}
