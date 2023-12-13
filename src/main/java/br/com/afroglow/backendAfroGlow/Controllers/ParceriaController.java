package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Models.Parceria;
import br.com.afroglow.backendAfroGlow.Service.ParceriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcerias")
public class ParceriaController {

    @Autowired
    private ParceriaService parceriaService;

    @GetMapping
    public ResponseEntity<List<Parceria>> listarParcerias() {
        List<Parceria> parcerias = parceriaService.listarParcerias();
        return new ResponseEntity<>(parcerias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parceria> obterParceriaPorId(@PathVariable Long id) {
        return parceriaService.obterParceriaPorId(id)
                .map(parceria -> new ResponseEntity<>(parceria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Parceria> salvarParceria(@RequestBody Parceria parceria) {
        Parceria novaParceria = parceriaService.salvarParceria(parceria);
        return new ResponseEntity<>(novaParceria, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirParceria(@PathVariable Long id) {
        parceriaService.excluirParceria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
