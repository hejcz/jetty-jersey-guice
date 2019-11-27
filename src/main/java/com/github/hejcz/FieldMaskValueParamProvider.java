package com.github.hejcz;

import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.internal.inject.AbstractValueParamProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

@Singleton
class FieldMaskValueParamProvider extends AbstractValueParamProvider {
    @Inject
    public FieldMaskValueParamProvider(Provider<MultivaluedParameterExtractorProvider> mpep) {
        super(mpep, org.glassfish.jersey.model.Parameter.Source.ENTITY);
    }

    @Override
    protected Function<ContainerRequest, ?> createValueProvider(Parameter parameter) {
        if (!parameter.getRawType().equals(FieldMask.class)) {
            return null;
        }
        return req -> new FieldMask();
    }

    /**
     * Must be executed before default entity param provider.
     */
    @Override
    public PriorityType getPriority() {
        return Priority.HIGH;
    }
}
