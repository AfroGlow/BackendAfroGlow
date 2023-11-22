package br.com.afroglow.backendAfroGlow.Models;

public class Box {

    private int tipoDeBox;
    private String descricao;
    private double preco;

  
    public Box() {
    }

    public Box(int tipoDeBox, String descricao, double preco) {
        this.tipoDeBox = tipoDeBox;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getTipoDeBox() {
        return tipoDeBox;
    }

    public void setTipoDeBox(int tipoDeBox) {
        this.tipoDeBox = tipoDeBox;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
