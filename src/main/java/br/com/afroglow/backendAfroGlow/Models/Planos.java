package br.com.afroglow.backendAfroGlow.Models;

import javax.persistence.Entity;

@Entity
public class Planos {
        public int idPlano; 
        public int idUsuario;
        public int idTipoDePlano;
        public String statusPagamento;
    }

