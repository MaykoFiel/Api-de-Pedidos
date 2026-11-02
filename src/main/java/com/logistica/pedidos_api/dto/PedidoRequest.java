package com.logistica.pedidos_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PedidoRequest(
        @NotBlank(message = "O nome do cliente não pode estar vazio")
        String cliente,

        @Positive(message = "O valor total deve ser maior que zero")
        BigDecimal valorTotal
) {}
