package com.logistica.pedidos_api.repository;

import com.logistica.pedidos_api.model.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidosModel, UUID> {

}
