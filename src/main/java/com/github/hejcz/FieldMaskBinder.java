package com.github.hejcz;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class FieldMaskBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(FieldMaskFactory.class).to(FieldMask.class);
    }

    static class FieldMaskFactory implements Factory<FieldMask> {
        @Override
        public FieldMask provide() {
            return name -> true;
        }

        @Override
        public void dispose(FieldMask instance) {

        }
    }
}
