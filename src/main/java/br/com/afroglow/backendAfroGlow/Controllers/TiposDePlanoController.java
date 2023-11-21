package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.TiposDePlano;
import br.com.afroglow.backendAfroGlow.service.TiposDePlanoService;

@RestController
@RequestMapping(value = "tiposDePlano")
public class TiposDePlanoController {
    
    TiposDePlanoService tiposDePlanoService = new TiposDePlanoService();

    @GetMapping(value = "/{tiposDePlanoId}")
    public TiposDePlano getTiposDePlano(@PathVariable Integer tiposDePlanoId) {
        return tiposDePlanoService.buscaTiposDePlano(tiposDePlanoId);
}
}
