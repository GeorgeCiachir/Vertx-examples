package george.projects.demos.rest;

import george.projects.demos.model.SomeDTO;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestServiceVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceVerticle.class);

    @Override
    public void start(Future<Void> future) {
        LOGGER.info("Starting the RestServiceVerticle");

        Router router = Router.router(vertx);
        router.get("/articles/article/:id").handler(this::getById);
        router.get("/home").handler(ctx -> ctx.response().end("home"));

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        future.complete();
                    } else {
                        future.fail(result.cause());
                    }
                });
    }

    private void getById(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        SomeDTO someDTO = new SomeDTO(id, "Some content");

        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(someDTO));
    }

    @Override
    public void stop() {
        LOGGER.info("Stopping the RestServiceVerticle");
    }
}