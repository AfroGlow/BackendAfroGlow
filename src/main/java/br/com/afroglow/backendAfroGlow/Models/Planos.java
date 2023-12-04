package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



        
        public int idPlano;
        public String nomeDoPlano;
        public Float preco;
        public String duracao;
        public String descricao;
    }
