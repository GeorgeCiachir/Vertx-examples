package george.projects.demos.simpleserver;

import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeployTheSimpleServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeployTheSimpleServer.class);

    public static void main(String[] args) {
        LOGGER.info("Deploy using DeployTheSimpleServer main class");
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SimpleServerVerticle());
    }
}
