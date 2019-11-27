package com.github.hejcz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class SimpleEndpoint {

    @GET
    public String greeting() {
        return "Hello world";
    }

    @GET
    @Path("world")
    public String worldGreeting() {
        return "Hello WORLD";
    }

}
