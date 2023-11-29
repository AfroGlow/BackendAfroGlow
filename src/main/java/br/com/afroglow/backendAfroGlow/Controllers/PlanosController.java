package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.Planos;
import br.com.afroglow.backendAfroGlow.Service.PlanosService;

@RestController
@RequestMapping("/planos")
public class PlanosController {
    // Propriedade Service
    @Autowired
    private final PlanosService planosService;

    // Criando Construtor
    public PlanosController(PlanosService planosService) {
        this.planosService = planosService;
    }

    @GetMapping(value = "/{planosId}")
    public Optional<Planos> getPlanos(@PathVariable Integer planosId) {
        return planosService.buscaPlanos(planosId);
    }
}