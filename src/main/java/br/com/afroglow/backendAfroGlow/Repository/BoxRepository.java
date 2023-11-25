// src/main/java/br/com/afroglow/backendAfroGlow/Repository/BoxRepository.java

package br.com.afroglow.backendAfroGlow.Repository;

import br.com.afroglow.backendAfroGlow.Models.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
}