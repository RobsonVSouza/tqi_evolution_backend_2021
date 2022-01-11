package com.tqi.evolution.backend.project_tqi.exception;


import com.tqi.evolution.backend.project_tqi.constant.ExceptionMessage;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
    public class CustomException extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = {EntityNotFoundException.class})
        public ResponseEntity<Object> handleClientNotFound (Exception e, WebRequest r) {
            return new ResponseEntity<>(ExceptionMessage.CLIENT_NOT_FOUND, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(value = {ArgumentNotValidException.class})
    public ResponseEntity<Object> handleCustomException (ArgumentNotValidException e) {
        return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(
                MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
                WebRequest request){
            List<String> errors = new ArrayList<>();
            ex.getBindingResult().getAllErrors().stream().forEach(it -> errors.add(it.getDefaultMessage()));
            return new ResponseEntity<>(errors, new HttpHeaders(),HttpStatus.BAD_REQUEST);
        }


    }

