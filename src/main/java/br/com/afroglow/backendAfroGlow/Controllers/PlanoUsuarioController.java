package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;
import br.com.afroglow.backendAfroGlow.service.PlanoUsuarioService;

@RestController
@RequestMapping(value = "planoUsuario")
public class PlanoUsuarioController {
    
    PlanoUsuarioService planoUsuarioService = new PlanoUsuarioService();

    @GetMapping(value = "/{planoUsuarioId}")
    public PlanoUsuario getPlanoUsuario(@PathVariable Integer planoUsuarioId) {
        return planoUsuarioService.buscaPlanoUsuario(planoUsuarioId);
}
}
