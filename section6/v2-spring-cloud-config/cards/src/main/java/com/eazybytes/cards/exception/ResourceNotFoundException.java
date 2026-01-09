package com.eazybytes.cards.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String respource, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input %s : %s", respource, fieldName, fieldValue));
    }
}
