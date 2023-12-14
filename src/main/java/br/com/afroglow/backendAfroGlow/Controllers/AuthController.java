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





// @RestController
// @RequestMapping("auth")
// public class AuthenticationController {
//     @Autowired
//     private AuthenticationManager authenticationManager;
//     @Autowired
//     private UserRepository repository;
//     @Autowired
//     private TokenService tokenService;

//     @PostMapping("/login")
//     public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
//         var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
//         var auth = this.authenticationManager.authenticate(usernamePassword);

//         var token = tokenService.generateToken((User) auth.getPrincipal());

//         return ResponseEntity.ok(new LoginResponseDTO(token));
//     }

//     @PostMapping("/register")
//     public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
//         if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

//         String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//         User newUser = new User(data.login(), encryptedPassword, data.role());

//         this.repository.save(newUser);

//         return ResponseEntity.ok().build();
//     }
// }
