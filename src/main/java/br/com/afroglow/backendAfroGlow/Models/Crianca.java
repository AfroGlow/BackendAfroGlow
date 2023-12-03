package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "crianca")
public class Crianca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCrianca")
    private Long idCrianca;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "idDefinicaoDoCabelo", nullable = false)
    private String idDefinicaoDoCabelo;

    @Column(name = "nomeCompleto", nullable = false, length = 80)
    private String nomeCompleto;

    @Column(name = "nomeFantasia", nullable = false, length = 40)
    private String nomeFantasia;

    @Column(name = "dataDeNascimento", nullable = false)
    private Date dataDeNascimento;

    @Column(name = "status", nullable = false, length = 25)
    private String status;







    
    public Crianca() {
    }

    public Crianca(Long idUsuario, String idDefinicaoDoCabelo, String nomeCompleto, String nomeFantasia, Date dataDeNascimento, String status) {
        this.idUsuario = idUsuario;
        this.idDefinicaoDoCabelo = idDefinicaoDoCabelo;
        this.nomeCompleto = nomeCompleto;
        this.nomeFantasia = nomeFantasia;
        this.dataDeNascimento = dataDeNascimento;
        this.status = status;
    }

    public Long getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(Long idCrianca) {
        this.idCrianca = idCrianca;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdDefinicaoDoCabelo() {
        return idDefinicaoDoCabelo;
    }

    public void setIdDefinicaoDoCabelo(String idDefinicaoDoCabelo) {
        this.idDefinicaoDoCabelo = idDefinicaoDoCabelo;
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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date string) {
        this.dataDeNascimento = string;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
