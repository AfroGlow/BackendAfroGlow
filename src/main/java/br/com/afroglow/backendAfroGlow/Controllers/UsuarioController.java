package br.com.afroglow.backendAfroGlow.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

    UsuarioService usuarioService = new UsuarioService();

    @GetMapping(value = "/{usuarioId}")
    public Usuario getUsuario(@PathVariable Integer usuarioId) {
        return usuarioService.buscaUsuario(usuarioId);
}
}