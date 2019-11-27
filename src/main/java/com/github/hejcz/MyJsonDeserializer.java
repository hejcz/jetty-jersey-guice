package com.github.hejcz;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class MyJsonDeserializer extends JacksonJsonProvider {

    @Inject
    private FieldMaskHolder fieldMaskHolder;

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
        fieldMaskHolder.store();
        return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }
}
