package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.Planos;
import br.com.afroglow.backendAfroGlow.Service.PlanosService;

@RestController
@RequestMapping(value = "planos")
public class PlanosController {
    
    PlanosService planosService = new PlanosService();

    @GetMapping(value = "/{planosId}")
    public Planos getPlanos(@PathVariable Integer planosId) {
        return planosService.buscaPlanos(planosId);
}
}