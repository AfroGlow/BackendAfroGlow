package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.TipoDeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeUsuarioRepository extends JpaRepository<TipoDeUsuario, Integer> {
  
}
