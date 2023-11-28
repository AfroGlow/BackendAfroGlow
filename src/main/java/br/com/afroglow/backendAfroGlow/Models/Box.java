// package br.com.afroglow.backendAfroGlow.Models;

// import br.com.afroglow.backendAfroGlow.Controllers.BoxRequestDTO;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Box {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long idBox;

//     private String tipoDeBox;
//     private double preco;
//     private int qtdDeProdutos;

//     public Box() {
//     }

//     public Box(BoxRequestDTO data) {
//         this.tipoDeBox = data.getTipoDeBox();
//         this.preco = data.getPreco();
//     }

//     public Box(String tipoDeBox, double preco, int qtdDeProdutos) {
//         this.tipoDeBox = tipoDeBox;
//         this.preco = preco;
//         this.qtdDeProdutos = qtdDeProdutos;
//     }

//     public Long getIdBox() {
//         return idBox;
//     }

//     public void setIdBox(Long idBox) {
//         this.idBox = idBox;
//     }

//     public String getTipoDeBox() {
//         return tipoDeBox;
//     }

//     public void setTipoDeBox(String tipoDeBox) {
//         this.tipoDeBox = tipoDeBox;
//     }

//     public double getPreco() {
//         return preco;
//     }

//     public void setPreco(double preco) {
//         this.preco = preco;
//     }

//     public int getQtdDeProdutos() {
//         return qtdDeProdutos;
//     }

//     public void setQtdDeProdutos(int qtdDeProdutos) {
//         this.qtdDeProdutos = qtdDeProdutos;
//     }
// }
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

    // Construtor padrão necessário para JPA
    public Box() {
    }

    // Construtor que aceita um objeto BoxRequestDTO
    public Box(BoxRequestDTO boxRequestDTO) {
        // Implemente a lógica necessária para inicializar os campos com base no BoxRequestDTO
    }

    // Getters e setters

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
