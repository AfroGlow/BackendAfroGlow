package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.DefinicaoDoCabelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinicaoDoCabeloRepository extends JpaRepository<DefinicaoDoCabelo, Long> {
    Optional<DefinicaoDoCabelo> findById(Long id);

    void deleteById(Long id);
}
