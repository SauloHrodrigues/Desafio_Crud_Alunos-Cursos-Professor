package com.cursoadm.cursoadm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<String> handlerErrorObjetoNaoEncontradoException(ObjetoNaoEncontradoException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
