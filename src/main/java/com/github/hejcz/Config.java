package com.github.hejcz;

import org.glassfish.jersey.server.ResourceConfig;

public class Config extends ResourceConfig {
    public Config() {
        super();
        packages("com.github.hejcz");
    }
}
