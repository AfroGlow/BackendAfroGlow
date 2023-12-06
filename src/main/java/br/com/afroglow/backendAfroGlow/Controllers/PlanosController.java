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

    @GetMapping(value = "/{planoId}")
    public Optional<Planos> getPlano(@PathVariable Integer planoId) {
        return planosService.buscaPlanos(planoId);
    }

    @PostMapping
    public ResponseEntity<Planos> adicionarPlano(@RequestBody Planos planos) {
        planosService.adicionarPlano(planos);
        return new ResponseEntity<>(planos, HttpStatus.CREATED);
    }

    @PutMapping 
    public ResponseEntity<String> atualizarPlano(@RequestBody Planos planos, String body) {
        planosService.atualizarPlanos(planos);
        return new ResponseEntity<>("Plano atualizado com sucesso!", HttpStatus.OK);
    }
    

    @DeleteMapping("/{planoId}")
    public ResponseEntity<String> deletarPlano(@PathVariable Integer planoId) {
        planosService.deletarPlano(planoId);
        return new ResponseEntity<>("Plano deletado com sucesso!", HttpStatus.OK);
    }
}