package com.logistica.pedidos_api.dto;

import com.logistica.pedidos_api.model.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PedidoResponse(
        UUID id,
        String cliente,
        BigDecimal valorTotal,
        StatusPedido status,
        LocalDateTime dataCriacao

) {
}
