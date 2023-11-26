package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Models.TipoDeUsuario;
import br.com.afroglow.backendAfroGlow.Service.TipoDeUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipodeusuario")
public class TipoDeUsuarioController {

    private final TipoDeUsuarioService tipoDeUsuarioService;

    @Autowired
    public TipoDeUsuarioController(TipoDeUsuarioService tipoDeUsuarioService) {
        this.tipoDeUsuarioService = tipoDeUsuarioService;
    }

    @PostMapping
    public ResponseEntity<TipoDeUsuario> adicionarTipoDeUsuario(@RequestBody TipoDeUsuario tipoDeUsuario) {
        tipoDeUsuarioService.adicionarTipoDeUsuario(tipoDeUsuario);
        return new ResponseEntity<>(tipoDeUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/visualizar/{descricao}")
    public ResponseEntity<TipoDeUsuario> visualizarTipoDeUsuario(@PathVariable String descricao) {
        TipoDeUsuario tipoDeUsuario = tipoDeUsuarioService.visualizarTipoDeUsuario(descricao);

        if (tipoDeUsuario != null) {
            return new ResponseEntity<>(tipoDeUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<TipoDeUsuario> atualizarTipoDeUsuario(@RequestBody TipoDeUsuario tipoDeUsuario) {
        tipoDeUsuarioService.atualizarTipoDeUsuario(tipoDeUsuario);
        return new ResponseEntity<>(tipoDeUsuario, HttpStatus.OK);
    }

    // @DeleteMapping("/{descricao}")
    // public ResponseEntity<String> deletarTipoDeUsuario(@PathVariable String descricao) {
    //     tipoDeUsuarioService.deletarTipoDeUsuario(descricao);
    //     return new ResponseEntity<>("Tipo de usuário deletado com sucesso!", HttpStatus.OK);
    // }
}
