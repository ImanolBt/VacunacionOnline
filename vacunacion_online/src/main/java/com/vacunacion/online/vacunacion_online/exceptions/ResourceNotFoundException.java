package com.vacunacion.online.vacunacion_online.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(final String message){
        super(message);
    }

}
