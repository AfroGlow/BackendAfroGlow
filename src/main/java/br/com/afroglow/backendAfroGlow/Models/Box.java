package br.com.afroglow.backendAfroGlow.Models;

import br.com.afroglow.backendAfroGlow.DTO.BoxRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "box")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBox")
    private Long idBox;

    @Column(nullable = false)
    private String tipoDeBox;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer qtdDeProdutos;


    public Box() {
    }

  
    public Box(BoxRequestDTO boxRequestDTO) {
   
    }

  

    public Long getIdBox() {
        return idBox;
    }

    public void setIdBox(Long idBox) {
        this.idBox = idBox;
    }

    public String getTipoDeBox() {
        return tipoDeBox;
    }

    public void setTipoDeBox(String tipoDeBox) {
        this.tipoDeBox = tipoDeBox;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdDeProdutos() {
        return qtdDeProdutos;
    }

    public void setQtdDeProdutos(Integer qtdDeProdutos) {
        this.qtdDeProdutos = qtdDeProdutos;
    }
}
