package com.tqi.evolution.backend.project_tqi.exception;

public class ArgumentNotValidException extends RuntimeException {

    public ArgumentNotValidException(String messageError) {
        super(messageError);
    }
}
