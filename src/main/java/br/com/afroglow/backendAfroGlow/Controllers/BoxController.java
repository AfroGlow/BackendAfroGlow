// src/main/java/br/com/afroglow/backendAfroGlow/Controller/BoxController.java

package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Models.Box;
import br.com.afroglow.backendAfroGlow.Service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/boxes")
public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping
    public List<Box> listarBoxes() {
        return boxService.listarBoxes();
    }

    @GetMapping("/{id}")
    public Box obterBox(@PathVariable Long id) {
        return boxService.obterBox(id);
    }

    @PostMapping
    public Box salvarBox(@RequestBody Box box) {
        return boxService.salvarBox(box);
    }

    @DeleteMapping("/{id}")
    public void deletarBox(@PathVariable Long id) {
        boxService.deletarBox(id);
    }
}
