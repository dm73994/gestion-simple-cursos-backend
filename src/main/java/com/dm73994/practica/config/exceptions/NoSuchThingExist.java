package com.dm73994.practica.config.exceptions;

public class NoSuchThingExist extends RuntimeException {
    private String message;

    public NoSuchThingExist(){}

    public NoSuchThingExist(String message) {
        super(message);
        this.message = message;
    }
}
