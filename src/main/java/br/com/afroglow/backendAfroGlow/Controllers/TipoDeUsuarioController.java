package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Service.TipoDeUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipodeusuario")
public class TipoDeUsuarioController {

    private final TipoDeUsuarioService tipoDeUsuarioService;

    @Autowired
    public TipoDeUsuarioController(TipoDeUsuarioService tipoDeUsuarioService) {
        this.tipoDeUsuarioService = tipoDeUsuarioService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarDescricao() {
        tipoDeUsuarioService.adicionarDescricao();
        return new ResponseEntity<>("Descrição adicionada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> visualizarDescricao() {
        tipoDeUsuarioService.visualizarDescricao();
        return new ResponseEntity<>(tipoDeUsuarioService.getDescricao(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> atualizarDescricao() {
        tipoDeUsuarioService.atualizarDescricao();
        return new ResponseEntity<>("Descrição atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarDescricao() {
        tipoDeUsuarioService.deletarDescricao();
        return new ResponseEntity<>("Descrição deletada com sucesso!", HttpStatus.OK);
    }
}
