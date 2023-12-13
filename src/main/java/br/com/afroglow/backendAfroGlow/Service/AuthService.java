package br.com.afroglow.backendAfroGlow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String nomeCompleto, String senha) {

        if (nomeCompleto == null || senha == null) {
            return false;
        }

        Usuario usuario = usuarioRepository.findByNomeCompletoAndSenha(nomeCompleto, senha);

        return usuario != null;
    }
}
