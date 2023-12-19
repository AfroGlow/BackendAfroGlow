package br.com.afroglow.backendAfroGlow.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    public String hashPassword(String password) {
        return password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    public int idUsuario;

    public int idDefinicaoDeCabelo;
    public String token;
    public int idTipoDeUsuario;
    public String nomeCompleto;
    public String nomeSocial;
    public Date dataDeNascimento;
    public String genero;
    public String email;
    public String senha;
    public String telefone;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIdTipoDeUsuario(Integer tipoDeUsuarioId) {
        this.idTipoDeUsuario = tipoDeUsuarioId;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}
