package br.com.afroglow.backendAfroGlow.Models;

import br.com.afroglow.backendAfroGlow.Controllers.BoxRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Box {

       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int tipoDeBox;
    private String descricao;
    private double preco;

    public Box() {
    }
  
    public Box(BoxRequestDTO data) {
        this.tipoDeBox = data.getTipoDeBox();
        this.descricao = data.getDescricao();
        this.preco = data.getPreco();
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
