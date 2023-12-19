package br.com.afroglow.backendAfroGlow.Models;



public class LoginRequest {


    public String senha;
    public String email;

   

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
         return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
