package br.com.afroglow.backendAfroGlow.Models;

public class Box {
    private int tipoDeBox;
    private double preco;
    private int qtdDeProdutos;


    // Exemplo de construtor
    public Box(int tipoDeBox, double preco, int qtdDeProdutos) {
        this.tipoDeBox = tipoDeBox;
        this.preco = preco;
        this.qtdDeProdutos = qtdDeProdutos;
    }

    public int getTipoDeBox() {
        return 0;
    }

    public void setPreco(double novoPreco) {
      // TODO document why this method is empty
    }

    // Getters e setters...
}