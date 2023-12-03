package br.com.afroglow.backendAfroGlow.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.afroglow.backendAfroGlow.Models.Perfumaria;
import br.com.afroglow.backendAfroGlow.Service.PerfumariaService;

import java.util.List;

@RestController
@RequestMapping("/perfumarias")
public class PerfumariaController {

    private final PerfumariaService perfumariaService;

    @Autowired
    public PerfumariaController(PerfumariaService perfumariaService) {
        this.perfumariaService = perfumariaService;
    }

    @GetMapping
    public ResponseEntity<List<Perfumaria>> getAllPerfumarias() {
        List<Perfumaria> perfumarias = perfumariaService.getAllPerfumarias();
        return new ResponseEntity<>(perfumarias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfumaria> getPerfumariaById(@PathVariable Long id) {
        return perfumariaService.getPerfumariaById(id)
                .map(perfumaria -> new ResponseEntity<>(perfumaria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Perfumaria> savePerfumaria(@RequestBody Perfumaria perfumaria) {
        Perfumaria savedPerfumaria = perfumariaService.savePerfumaria(perfumaria);
        return new ResponseEntity<>(savedPerfumaria, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfumaria(@PathVariable Long id) {
        perfumariaService.deletePerfumaria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}