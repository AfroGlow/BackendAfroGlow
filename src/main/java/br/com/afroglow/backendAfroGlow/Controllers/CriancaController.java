package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.DTO.CriancaRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.Crianca;
import br.com.afroglow.backendAfroGlow.Service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crianca")
@CrossOrigin(origins = "*")
public class CriancaController {

    @Autowired
    private CriancaService criancaService;

    @GetMapping
    public List<Crianca> getAllCriancas() {
        return criancaService.getAllCriancas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crianca> getCriancaById(@PathVariable Long id) {
        Optional<Crianca> crianca = criancaService.getCriancaById(id);
        return crianca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Crianca> createCrianca(@RequestBody CriancaRequestDTO criancaRequestDTO) {
        Crianca crianca = mapCriancaRequestDTOToCrianca(criancaRequestDTO);
        Crianca savedCrianca = criancaService.createCrianca(crianca);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCrianca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crianca> updateCrianca(@PathVariable Long id, @RequestBody CriancaRequestDTO criancaRequestDTO) {
        Optional<Crianca> updatedCrianca = criancaService.updateCrianca(id, criancaRequestDTO);
        return updatedCrianca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrianca(@PathVariable Long id) {
        boolean deleted = criancaService.deleteCrianca(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Crianca mapCriancaRequestDTOToCrianca(CriancaRequestDTO criancaRequestDTO) {
        Crianca crianca = new Crianca();
   
        crianca.setDataDeNascimento(criancaRequestDTO.getDataDeNascimento());
        crianca.setIdDefinicaoDoCabelo(criancaRequestDTO.getIdDefinicaoDoCabelo());
        crianca.setIdUsuario(criancaRequestDTO.getIdUsuario());
        crianca.setNomeCompleto(criancaRequestDTO.getNomeCompleto());
        crianca.setNomeFantasia(criancaRequestDTO.getNomeFantasia());
        crianca.setStatus(criancaRequestDTO.getStatus());
      

        return crianca;
    }
}
;