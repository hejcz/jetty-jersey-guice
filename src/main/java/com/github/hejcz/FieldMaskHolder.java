package com.github.hejcz;

import org.glassfish.jersey.process.internal.RequestScoped;

@RequestScoped
public class FieldMaskHolder {

    private FieldMask mask;

    public void store() {
        System.out.println(hashCode());
        System.out.println("stored");
        mask = name -> true;
    }

    public FieldMask get() {
        System.out.println(hashCode());
        return mask;
    }

}
