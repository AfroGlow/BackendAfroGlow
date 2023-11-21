package br.com.afroglow.backendAfroGlow.Models;

import java.util.Date;

public class Crianca {
    private String nomeCompleto;
    private String nomeFantasia;
    private Date dataDeNascimento;
    private String status;

    public Crianca(String nomeCompleto, String nomeFantasia, Date dataDeNascimento, String status) {
        this.nomeCompleto = nomeCompleto;
        this.nomeFantasia = nomeFantasia;
        this.dataDeNascimento = dataDeNascimento;
        this.status = status;
    }

    public Object getNomeCompleto() {
        return null;
    }

    public void setStatus(String novoStatus) {

    }

    // Getters e setters...
}