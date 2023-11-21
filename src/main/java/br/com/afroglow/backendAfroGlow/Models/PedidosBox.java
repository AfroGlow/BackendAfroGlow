package br.com.afroglow.backendAfroGlow.Models;

public class PedidosBox {
    private int idPedidosBox;
    private int idUsuario;
    private int idBox;
    private int idPagamento;

    // Construtores, getters e setters aqui...

    // Exemplo de construtor
    public PedidosBox(int idPedidosBox, int idUsuario, int idBox, int idPagamento) {
        this.idPedidosBox = idPedidosBox;
        this.idUsuario = idUsuario;
        this.idBox = idBox;
        this.idPagamento = idPagamento;
    }

    public int getIdPedidosBox() {
        return 0;
    }

    public void setIdPagamento(int novoIdPagamento) {
    }

    // Getters e setters...
}
