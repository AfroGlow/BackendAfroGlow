package br.com.afroglow.backendAfroGlow.Models;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pagamento {
    @Id
        public int idPagamento;
        public int idUsuario;
        public String status;
    }

