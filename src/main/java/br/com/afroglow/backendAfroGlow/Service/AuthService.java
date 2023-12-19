package br.com.afroglow.backendAfroGlow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Repository.UsuarioRepository;


@Service
public class AuthService {

    @Autowired

    
private UsuarioRepository usuarioRepository;

    public boolean autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        
   
        if (usuario != null) {
        
            return true;
        } else {
           
            return false;
        }
    }

    public String gerarToken(Usuario usuario) {
        return null;
    }
}