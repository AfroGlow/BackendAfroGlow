package br.com.afroglow.backendAfroGlow.Models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos_box")
public class PedidoBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_box")
    private Long idPedidoBox;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_box", nullable = false)
    private Long idBox;

    @Column(name = "id_pagamento")
    private Long idPagamento;

    // Getters and setters

    public Long getIdPedidoBox() {
        return idPedidoBox;
    }

    public void setIdPedidoBox(Long idPedidoBox) {
        this.idPedidoBox = idPedidoBox;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdBox() {
        return idBox;
    }

    public void setIdBox(Long idBox) {
        this.idBox = idBox;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }
}
