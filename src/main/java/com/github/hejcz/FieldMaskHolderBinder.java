package com.github.hejcz;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

class FieldMaskHolderBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(new FieldMaskHolderFactory()).to(FieldMaskHolder.class)
            .proxy(true).proxyForSameScope(false).in(RequestScoped.class);
    }
}
