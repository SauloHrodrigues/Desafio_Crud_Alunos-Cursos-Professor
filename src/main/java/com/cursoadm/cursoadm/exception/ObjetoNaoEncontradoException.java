package com.cursoadm.cursoadm.exception;

import org.springframework.http.HttpStatus;

public class ObjetoNaoEncontradoException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;//404
    }
}
