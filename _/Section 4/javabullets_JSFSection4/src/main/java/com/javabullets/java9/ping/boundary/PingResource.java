package com.javabullets.java9.ping.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * http://localhost:8080/javabullets/resources/ping
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @GET
    public String ping() {
        return "Enjoy Java EE 8!";
    }

}
