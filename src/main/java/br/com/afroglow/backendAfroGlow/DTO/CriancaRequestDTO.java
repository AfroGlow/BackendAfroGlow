package br.com.afroglow.backendAfroGlow.DTO;

import java.sql.Date;

public class CriancaRequestDTO {
    private Date dataDeNascimento;
    private String idDefinicaoDoCabelo;
    private Long idUsuario;
    private String nomeCompleto;
    private String nomeFantasia;
    private String status;

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getIdDefinicaoDoCabelo() {
        return idDefinicaoDoCabelo;
    }

    public void setIdDefinicaoDoCabelo(String idDefinicaoDoCabelo) {
        this.idDefinicaoDoCabelo = idDefinicaoDoCabelo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdCrianca(Long id) {
    }
}
