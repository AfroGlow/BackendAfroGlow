package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Service.UsuarioService;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*")
public class UsuarioController {
    // Propriedade Service
    @Autowired
    private final UsuarioService usuarioService;

    // Criando construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/{usuarioId}")
    public Optional<Usuario> getUsuario(@PathVariable Integer usuarioId) {
        return usuarioService.buscarUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        usuarioService.adicionarUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping

    public ResponseEntity<HttpStatus> atualizarTipoDeUsuario(@RequestBody Integer tipoDeUsuarioId, @RequestBody Integer usuarioId) {
        usuarioService.atualizarTipoDeUsuario(tipoDeUsuarioId, usuarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return new ResponseEntity<>("Usuário atualizado com sucesso!", HttpStatus.OK);

    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Integer usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
        return new ResponseEntity<>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    
}