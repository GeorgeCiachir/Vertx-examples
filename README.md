# Vertx examples

## HelloVerticle
Very simple verticle

## SimpleServerVerticle
Starts a io.vertx.core.http.HttpServer that listens on port 8080 and responds depending on the request URI (manual URI check)
Can be deployed with DeployTheSimpleServer

## RestServiceVerticle
Starts a io.vertx.core.http.HttpServer that uses a router and listens on port (multiple endpoints)
Can be deployed with DeployTheRestServiceVerticle


## Running the verticles
All 3 verticles can be launched from CL after mvn build, by changing the <Main-Verticle> in pom.xml
Also, a <Main-Class> must be specified (this is the class that actually instantiates the verticles - the verticle runner
that has the main(String[] args) method)
Can also launch the verticles as stand-alone, using the DeployTheSimpleServer or DeployTheRestServiceVerticle or even
HelloVerticle as the <Main-Class> in which cases <Main-Verticle> is no longer required because the mentioned classes 
instantiate the corresponding verticle.

For IntelliJ configuration use: run george.projects.demos.simpleserver.SimpleServerVerticle -conf src/main/resources/config.json as the program arguments
