package com.logistica.pedidos_api.exception;

public record ErroValidacaoException(String campo, String mensagem) {
}
