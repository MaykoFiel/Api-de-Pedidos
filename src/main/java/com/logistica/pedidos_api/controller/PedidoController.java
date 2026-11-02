package com.logistica.pedidos_api.controller;

import com.logistica.pedidos_api.dto.PedidoRequest;
import com.logistica.pedidos_api.dto.PedidoResponse;
import com.logistica.pedidos_api.model.PedidosModel;
import com.logistica.pedidos_api.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;


    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@Valid @RequestBody PedidoRequest request) {
        PedidosModel novoPedido = new PedidosModel();
        novoPedido.setCliente(request.cliente());
        novoPedido.setValorTotal(request.valorTotal());

        PedidosModel pedidoSalvo = service.criarPedido(novoPedido);


        return ResponseEntity.status(HttpStatus.CREATED).body(converterParaResponse(pedidoSalvo));
    }

    @PatchMapping("/{id}/pagar")
    public ResponseEntity<PedidoResponse> pagarPedido(@PathVariable UUID id) {
       PedidosModel pedidoAtualizado = service.marcarComoPago(id);
       return ResponseEntity.ok(converterParaResponse(pedidoAtualizado));
    }

    @GetMapping
    public ResponseEntity<Page<PedidoResponse>> listarPedidos(@PageableDefault (size = 10) Pageable paginacao) {
        Page<PedidosModel> pedidosPage = service.listarPedidos(paginacao);

     Page<PedidoResponse> respostas = pedidosPage.map(this::converterParaResponse);

     return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable UUID id) {
       PedidosModel pedidoBuscado = service.buscarPedido(id);
       return ResponseEntity.ok(converterParaResponse(pedidoBuscado));
    }

    // 2. Nossa fábrica de conversão que evita repetição de código
    private PedidoResponse converterParaResponse(PedidosModel pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.getDataCriacao()
        );
    }
}
