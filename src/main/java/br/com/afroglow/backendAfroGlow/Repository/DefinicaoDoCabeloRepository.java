package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.DefinicaoDoCabelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinicaoDoCabeloRepository extends JpaRepository<DefinicaoDoCabelo, Integer> {
    // Se necessário, você pode adicionar métodos personalizados aqui
}
