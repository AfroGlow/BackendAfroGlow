package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;

import br.com.afroglow.backendAfroGlow.DTO.UserRole;

@Entity
public class Usuario {

  public Usuario() {
    }

public Usuario(String nomeCompleto2, String senha2) {
}

public String hashPassword(String password) {
    return password;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  public int idUsuario;

  @Column(name = "login")
  private String login;

  public int idDefinicaoDeCabelo;

  public int idTipoDeUsuario;

  public String nomeCompleto;

  public String nomeSocial;

  public Date dataDeNascimento;

  public String genero;

  public String email;

  public String senha;

  public String telefone;

  private String cpf;

  private String status;

  public int size() {
    return 0;
  }

  public String getLogin() {
    return null;
  }
}
