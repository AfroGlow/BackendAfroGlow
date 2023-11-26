package br.com.afroglow.backendAfroGlow.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Planos {
        public int idPlano;
        public String nomeDoPlano;
        public Float preco;
        public String duracao;
        public String descricao;
    }


