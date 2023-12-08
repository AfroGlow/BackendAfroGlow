package br.com.afroglow.backendAfroGlow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.afroglow.backendAfroGlow.Models.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
}