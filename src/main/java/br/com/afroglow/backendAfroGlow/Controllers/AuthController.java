package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroglow.backendAfroGlow.Service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String nomeCompleto = request.getNomeCompleto();
        String senha = request.getSenha();
    
        System.out.println("Recebido login para: " + nomeCompleto);
    
        if (authService.autenticar(nomeCompleto, senha)) {
            System.out.println("Login bem-sucedido para: " + nomeCompleto);
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            System.out.println("Login falhou para: " + nomeCompleto);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
    
}
