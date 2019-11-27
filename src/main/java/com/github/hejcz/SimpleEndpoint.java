package com.github.hejcz;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("hello")
public class SimpleEndpoint {

    /**
     * Trick in HK2 bridge is you can't use guice specific stuff when you inject guice
     * beans to HK2 beans e.g. you can;t define custom BindingAnnotation to inject version
     * string here. Instead you need to use javax.inject.Named. Even com.google.inject.name.Named
     * does not work.
     */
    @Inject
    SimpleEndpoint(Service service, @Named("version") String version) {
    }

    @GET
    public String greeting() {
        return "Hello";
    }

    /**
     * Presence of any annotation makes this parameter's source UNKNOWN so FieldMaskValueParamProvider
     * might be used. If no annotation is present ENTITY source is assumed.
     * 
     * @see org.glassfish.jersey.model.Parameter.Source
     * @see com.github.hejcz.FieldMaskValueParamProvider
     */
    @POST
    public void addCustomParam(@Mask FieldMask mask) {
        System.out.println(mask);
    }

}
