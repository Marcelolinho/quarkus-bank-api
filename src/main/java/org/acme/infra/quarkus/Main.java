package org.acme.infra.quarkus;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Logger.getLogger("MAIN").info("INITIALIZING APPLICATION....LOADING🔐...");

        Quarkus.run(args);
    }
}
