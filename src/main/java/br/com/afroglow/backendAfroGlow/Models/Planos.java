package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlano;

    private String nomeDoPlano;
    private Float preco;
    private String duracao;
    private String descricao;

    // getters and setters
}
