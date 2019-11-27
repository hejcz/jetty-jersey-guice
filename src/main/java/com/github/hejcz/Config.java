package com.github.hejcz;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class Config extends ResourceConfig {

    @Inject
    public Config(ServiceLocator serviceLocator) {
        super();
        packages("com.github.hejcz");
        setupHK2GuiceBridge(serviceLocator);
    }

    private void setupHK2GuiceBridge(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge bridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        Injector injector = Guice.createInjector(binder -> {
            binder.bind(Service.class).toInstance(new SpecificService());
            binder.bindConstant().annotatedWith(Names.named("version")).to("1.0.0");
        });
        bridge.bridgeGuiceInjector(injector);
    }
}
