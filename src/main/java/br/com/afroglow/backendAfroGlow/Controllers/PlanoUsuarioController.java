package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;
import br.com.afroglow.backendAfroGlow.Service.PlanoUsuarioService;

@RestController
@RequestMapping("/planoUsuario")
public class PlanoUsuarioController {
    //Propriedade Service
    @Autowired
    private final PlanoUsuarioService planoUsuarioService;
    //Criando construtor
    public PlanoUsuarioController (PlanoUsuarioService planoUsuarioService){
        this.planoUsuarioService = planoUsuarioService;
    }

    @GetMapping(value = "/{planoUsuarioId}")
    public Optional<PlanoUsuario> getPlanoUsuario(@PathVariable Integer planoUsuarioId) {
        return planoUsuarioService.buscaPlanoUsuario(planoUsuarioId);
}
}
