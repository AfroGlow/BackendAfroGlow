package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.DTO.User;
import br.com.afroglow.backendAfroGlow.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    void save(User newUser);
    Usuario findByNomeCompletoAndSenha(String nomeCompleto, String senha);
    
    UserDetails findByLogin(String login);

 
}