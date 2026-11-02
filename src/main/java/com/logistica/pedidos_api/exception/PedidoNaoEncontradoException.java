package com.logistica.pedidos_api.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String message) {
        super(message);
    }
}
