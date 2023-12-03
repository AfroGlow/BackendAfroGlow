package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanoUsuario;


        @Id
        public int idPlanoUsuario; 
        public int idUsuario;
        public int idPlano;
        public String statusPagamento;
    }



}