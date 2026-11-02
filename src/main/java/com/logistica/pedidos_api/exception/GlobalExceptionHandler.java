package com.logistica.pedidos_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoException>> tratarErrosDeValidacao(MethodArgumentNotValidException ex) {

        var errosDostring = ex.getFieldErrors();

        List<ErroValidacaoException> errosLimpos = errosDostring.stream()
                .map(erro -> new ErroValidacaoException(erro.getField(), erro.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errosLimpos);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<String> tratarPedidoNaoEncontrado(PedidoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
