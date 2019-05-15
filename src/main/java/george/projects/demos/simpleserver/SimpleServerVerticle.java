package george.projects.demos.simpleserver;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleServerVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleServerVerticle.class);

    @Override
    public void start(Future<Void> future) {
        LOGGER.info("Starting the SimpleServerVerticle");

        vertx.createHttpServer()
                .requestHandler(request -> {
                    String response = request.uri().equals("/health") ? "Up and running" : "Welcome !";
                    request.response().end(response);
                })
                .listen(config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        future.complete();
                    } else {
                        future.fail(result.cause());
                    }
                });
    }

    @Override
    public void stop() {
        LOGGER.info("Stopping the SimpleServerVerticle");
    }
}