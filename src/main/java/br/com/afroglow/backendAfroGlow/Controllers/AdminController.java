package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Models.Admin;
import br.com.afroglow.backendAfroGlow.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarAdmin(@RequestBody Admin admin) {
        adminService.adicionarAdmin(admin);
        return new ResponseEntity<>("Administrador adicionado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/{idAdmin}")
    public ResponseEntity<Admin> visualizarAdmin(@PathVariable Integer adminId) {
        Admin admin = adminService.visualizarAdmin(adminId);

        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarAdmin(@RequestBody Admin admin) {
        adminService.atualizarAdmin(admin);
        return new ResponseEntity<>("Administrador atualizado com sucesso!", HttpStatus.OK);
    }

    // Você pode adicionar endpoints para outras operações, como exclusão, se necessário.
}
