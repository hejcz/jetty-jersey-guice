package com.github.hejcz;

import org.glassfish.hk2.api.Factory;

public class FieldMaskHolderFactory implements Factory<FieldMaskHolder> {
    @Override
    public FieldMaskHolder provide() {
        return new FieldMaskHolder();
    }

    @Override
    public void dispose(FieldMaskHolder instance) {

    }
}
