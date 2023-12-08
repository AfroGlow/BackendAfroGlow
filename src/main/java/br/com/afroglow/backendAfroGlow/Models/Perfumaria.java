package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "perfumarias")
public class Perfumaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerfumaria")
    private Integer idPerfumaria;

    @Column(name = "nomePerfumaria", nullable = false)
    private String nomePerfumaria;

    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;

    @Column(name = "telefone", nullable = false)
    private String telefone;

 

    public Integer getIdPerfumaria() {
        return idPerfumaria;
    }

    public void setIdPerfumaria(Integer idPerfumaria) {
        this.idPerfumaria = idPerfumaria;
    }

    public String getNomePerfumaria() {
        return nomePerfumaria;
    }

    public void setNomePerfumaria(String nomePerfumaria) {
        this.nomePerfumaria = nomePerfumaria;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
