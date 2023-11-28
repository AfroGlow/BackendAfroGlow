package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Se necessário, você pode adicionar métodos personalizados aqui
}
