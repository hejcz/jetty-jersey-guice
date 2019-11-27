package com.github.hejcz;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class SimpleEndpoint {
    @Inject
    SimpleEndpoint(Service service, @Named("version") String version) {
        System.out.println(version);
    }

    @GET
    public String greeting() {
        return "Hello";
    }

}
