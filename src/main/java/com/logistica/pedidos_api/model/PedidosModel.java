package com.logistica.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_pedidos")
@Data
public class PedidosModel {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "nome_cliente")
    private String cliente;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

}