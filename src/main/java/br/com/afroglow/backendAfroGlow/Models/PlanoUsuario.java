package br.com.afroglow.backendAfroGlow.Models;

import javax.persistence.Entity;

@Entity
public class PlanoUsuario {
        public int idPlanoUsuario; 
        public int idUsuario;
        public int idTipoDePlano;
        public String statusPagamento;
    }

