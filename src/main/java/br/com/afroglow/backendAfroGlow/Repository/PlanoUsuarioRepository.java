package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoUsuarioRepository extends JpaRepository<PlanoUsuario, Integer> {
    // Se necessário, você pode adicionar métodos personalizados aqui
}