package br.com.afroglow.backendAfroGlow.Models;

import javax.persistence.Entity;

@Entity 
public class Pagamento {
        public int idPagamento;
        public int idUsuario;
        public String status;
    }

