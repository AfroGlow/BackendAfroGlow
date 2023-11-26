package br.com.afroglow.backendAfroGlow.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan 
public class Pagamento {
        public int idPagamento;
        public int idUsuario;
        public String status;
    }

