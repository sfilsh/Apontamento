package com.apontamento.main.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity errorNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
           IllegalArgumentException.class
    })
    public ResponseEntity errorBadRequest() {
        return ResponseEntity.badRequest().build();
    }

//    @ExceptionHandler({
//        AccessDeniedException.class,
//    })
//    public ResponseEntity accessDenied() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MsgError("Acesso negado"));
//    }
}