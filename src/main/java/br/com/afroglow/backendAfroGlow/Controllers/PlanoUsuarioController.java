package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;
import br.com.afroglow.backendAfroGlow.Service.PlanoUsuarioService;

@RestController
@RequestMapping("/planoUsuario")
public class PlanoUsuarioController {
    // Propriedade Service
    @Autowired
    private final PlanoUsuarioService planoUsuarioService;

    // Criando construtor
    public PlanoUsuarioController(PlanoUsuarioService planoUsuarioService) {
        this.planoUsuarioService = planoUsuarioService;
    }

    @GetMapping(value = "/{planoUsuarioId}")
    public Optional<PlanoUsuario> getPlanoUsuario(@PathVariable Integer planoUsuarioId) {
        return planoUsuarioService.buscaPlanoUsuario(planoUsuarioId);
    }
    // //Conferir se faz sentido
    @PostMapping
    public ResponseEntity<PlanoUsuario> adicionarPlanoUsuario(@RequestBody PlanoUsuario planoUsuario) {
    planoUsuarioService.adicionarPlanoUsuario(planoUsuario);
    return new ResponseEntity<>(planoUsuario, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarPlanoUsuario(@RequestBody PlanoUsuario planoUsuario) {
        planoUsuarioService.atualizarPlanoUsuario(planoUsuario);
        return new ResponseEntity<>("Plano atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{planoUsuarioId}")
    public ResponseEntity<String> deletarPlanoUsuario(@PathVariable Integer planoUsuarioId) {
        planoUsuarioService.deletarPlanoUsuario(planoUsuarioId);
        return new ResponseEntity<>("Plano deletado com sucesso!", HttpStatus.OK);
    }
}
