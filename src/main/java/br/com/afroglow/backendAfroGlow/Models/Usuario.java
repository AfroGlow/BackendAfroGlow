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


}













// @Entity
// public class Usuario {

//    @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_usuario")
//     public int idUsuario;

//     public int idDefinicaoDeCabelo;

//     public int idTipoDeUsuario;

//     public String nomeCompleto;

//     public String nomeSocial;

//     public Date dataDeNascimento;

//     public String genero;

//     public String email;

//     public String senha;

//     public String telefone;

//     public String cpf;
    
//     public String status;
// }
