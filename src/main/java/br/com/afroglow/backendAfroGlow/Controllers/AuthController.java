package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Service.AuthService;
import br.com.afroglow.backendAfroGlow.Service.UsuarioService;
import br.com.afroglow.backendAfroGlow.Infra.Security.TokenService;
import br.com.afroglow.backendAfroGlow.Models.LoginRequest;
import br.com.afroglow.backendAfroGlow.Models.Usuario;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String senha = request.getSenha();

        if (authService.autenticar(email, senha)) {
            Usuario usuario = usuarioService.buscarUsuarioPorEmail(email).orElse(null);

            if (usuario != null) {
                String token = tokenService.gerarToken(usuario.getEmail()); // Corrigido para usuario.getEmail()
                return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error" + "Credenciais inválidas");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error" + "Credenciais inválidas");
        }
    }

    @PostMapping("/session")
    public ResponseEntity<Object> startSession(@RequestBody LoginRequest request) {

     Optional<Usuario> user = usuarioService.buscarUsuarioPorEmail(request.getEmail());

     return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
