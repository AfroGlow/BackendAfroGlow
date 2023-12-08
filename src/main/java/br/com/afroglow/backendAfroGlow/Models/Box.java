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
//     private Integer idBox;

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

//     public Integer getIdBox() {
//         return idBox;
//     }

//     public void setIdBox(Integer idBox) {
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
    private Integer idBox;

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

  

    public Integer getIdBox() {
        return idBox;
    }

    public void setIdBox(Integer boxId) {
        this.idBox = boxId;
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
