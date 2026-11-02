package com.logistica.pedidos_api.service;

import com.logistica.pedidos_api.exception.PedidoNaoEncontradoException;
import com.logistica.pedidos_api.model.PedidosModel;
import com.logistica.pedidos_api.model.StatusPedido;
import com.logistica.pedidos_api.repository.PedidoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidosModel criarPedido(PedidosModel pedidoModel) {


        pedidoModel.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);

        return pedidoRepository.save(pedidoModel);
    }

    public PedidosModel marcarComoPago(UUID id) {

        PedidosModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado para o ID : " + id));

        pedido.setStatus(StatusPedido.PAGO);
        return pedidoRepository.save(pedido);
    }

   public Page<PedidosModel> listarPedidos(Pageable paginacao) {
        return pedidoRepository.findAll(paginacao);
   }

    public PedidosModel buscarPedido(UUID id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontardo para o ID : " + id));
    }
}
