package br.com.afroglow.backendAfroGlow.Models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class PlanoUsuario {
        public int idPlanoUsuario; 
        public int idUsuario;
        public int idTipoDePlano;
        public String statusPagamento;
    }

