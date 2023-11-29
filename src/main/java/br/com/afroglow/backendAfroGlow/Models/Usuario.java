package br.com.afroglow.backendAfroGlow.Models;


import java.util.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Usuario {
    public int idUsuario;
    public int idDefinicaoDeCabelo;
    public int idTipoDeUsuario;
    public String nomeCompleto;
    public String nomeSocial;
    public Date dataDeNascimento;
    public String genero;
    public String email;
    public String senha;
    public String telefone;
    public String cpf;
    public String status;
}

