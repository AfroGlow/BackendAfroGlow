package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.DTO.CriancaRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriancaRepository extends JpaRepository<Crianca, Long> {

    Crianca save(CriancaRequestDTO criancaRequestDTO);
  
}
