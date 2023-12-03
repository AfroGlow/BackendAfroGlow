package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Planos {

        @Id
        public int idPlano;
        public String nomeDoPlano;
        public Float preco;
        public String duracao;
        public String descricao;
    }


