package com.cursoadm.cursoadm.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
