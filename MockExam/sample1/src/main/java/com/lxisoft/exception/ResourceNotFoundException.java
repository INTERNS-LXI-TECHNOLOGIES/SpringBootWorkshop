package com.lxisoft.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1 ;

    public ResourceNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
}
