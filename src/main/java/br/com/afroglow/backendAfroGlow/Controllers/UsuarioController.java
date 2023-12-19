package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Service.UsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<?> getUsuario(@PathVariable Long usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUsuario(usuarioId);

        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @PostMapping(value = "/{usuarioEmail}")
    // public ResponseEntity<?> getUsuarioPorEmail(@RequestBody String usuarioPorEmail) {
    //     Optional<Usuario> usuarioOptional = usuarioService.buscarUsuarioPorEmail(usuarioPorEmail);

    //     if (usuarioOptional.isPresent()) {
    //         return ResponseEntity.ok(usuarioOptional.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        usuarioService.adicionarUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return new ResponseEntity<>("Usuário atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
        return new ResponseEntity<>("Usuário deletado com sucesso!", HttpStatus.OK);
    }
}
