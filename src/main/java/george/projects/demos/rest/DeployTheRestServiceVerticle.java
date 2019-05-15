package george.projects.demos.rest;

import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeployTheRestServiceVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeployTheRestServiceVerticle.class);

    public static void main(String[] args) {
        LOGGER.info("Deploy using DeployTheRestServiceVerticle main class");
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new RestServiceVerticle());
    }
}
