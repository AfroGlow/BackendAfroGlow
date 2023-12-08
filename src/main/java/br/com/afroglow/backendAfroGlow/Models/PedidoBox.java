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
    private Integer idPedidoBox;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_box", nullable = false)
    private Integer idBox;

    @Column(name = "id_pagamento")
    private Integer idPagamento;

    // Getters and setters

    public Integer getIdPedidoBox() {
        return idPedidoBox;
    }

    public void setIdPedidoBox(Integer idPedidoBox) {
        this.idPedidoBox = idPedidoBox;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdBox() {
        return idBox;
    }

    public void setIdBox(Integer idBox) {
        this.idBox = idBox;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }
}
