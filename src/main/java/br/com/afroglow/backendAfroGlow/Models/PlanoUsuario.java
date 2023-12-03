package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PlanoUsuario {

        @Id
        public int idPlanoUsuario; 
        public int idUsuario;
        public int idPlano;
        public String statusPagamento;
    }

