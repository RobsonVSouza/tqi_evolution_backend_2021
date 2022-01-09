package com.tqi.evolution.backend.project_tqi.exception;


import com.tqi.evolution.backend.project_tqi.constant.ExceptionMessage;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

    @ControllerAdvice
    public class ClientException extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = {EntityNotFoundException.class})
        public ResponseEntity<Object> handleClientNotFound (Exception e, WebRequest r) {
            return new ResponseEntity<>(ExceptionMessage.CLIENT_NOT_FOUND, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

    }

