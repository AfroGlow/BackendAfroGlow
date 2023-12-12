package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.Models.DefinicaoDoCabelo;
import br.com.afroglow.backendAfroGlow.Service.DefinicaoDoCabeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/definicaodocabelo")
@CrossOrigin(origins = "*")

public class DefinicaoDoCabeloController {

    private final DefinicaoDoCabeloService definicaoDoCabeloService;

    @Autowired
    public DefinicaoDoCabeloController(DefinicaoDoCabeloService definicaoDoCabeloService) {
        this.definicaoDoCabeloService = definicaoDoCabeloService;
    }

    @PostMapping
    public ResponseEntity<DefinicaoDoCabelo> adicionarDefinicaoDoCabelo(@RequestBody DefinicaoDoCabelo definicaoDoCabelo) {
        definicaoDoCabeloService.adicionarDefinicaoDoCabelo(definicaoDoCabelo);
        return new ResponseEntity<>(definicaoDoCabelo, HttpStatus.CREATED);
    }

    @GetMapping("/visualizar/{idDefinicaoDoCabelo}")
    public ResponseEntity<DefinicaoDoCabelo> visualizarDefinicaoDoCabelo(@PathVariable Long idDefinicaoDoCabelo) {
        DefinicaoDoCabelo definicaoDoCabelo = definicaoDoCabeloService.visualizarDefinicaoDoCabelo(idDefinicaoDoCabelo);

        if (definicaoDoCabelo != null) {
            return new ResponseEntity<>(definicaoDoCabelo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<DefinicaoDoCabelo> atualizarDefinicaoDoCabelo(@RequestBody DefinicaoDoCabelo definicaoDoCabelo) {
        definicaoDoCabeloService.atualizarDefinicaoDoCabelo(definicaoDoCabelo);
        return new ResponseEntity<>(definicaoDoCabelo, HttpStatus.OK);
    }

    @DeleteMapping("/{idDefinicaoDoCabelo}")
    public ResponseEntity<String> deletarDefinicaoDoCabelo(@PathVariable Long idDefinicaoDoCabelo) {
        definicaoDoCabeloService.deletarDefinicaoDoCabelo(idDefinicaoDoCabelo);
        return new ResponseEntity<>("Definição do cabelo deletada com sucesso!", HttpStatus.OK);
    }
}
