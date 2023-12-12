package br.com.afroglow.backendAfroGlow.DTO;

public class BoxRequestDTO {

    private String tipoDeBox;
    private String descricao;
    private double preco;

    public String getTipoDeBox() {
        return tipoDeBox;
    }

    public void setTipoDeBox(String tipoDeBox) {
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

    public Object getQtdDeProdutos() {
        return null;
    }
}
