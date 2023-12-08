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
@RequestMapping("/api/crianca")
@CrossOrigin(origins = "*")
public class CriancaController {

    @Autowired
    private CriancaService criancaService;

    @GetMapping
    public List<Crianca> getAllCriancas() {
        return criancaService.getAllCriancas();
    }

    @GetMapping("/{criancaId}")
    public ResponseEntity<Crianca> getCriancaById(@PathVariable Integer criancaId) {
        Optional<Crianca> crianca = criancaService.getCriancaById(criancaId);
        return crianca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Crianca> createCrianca(@RequestBody CriancaRequestDTO criancaRequestDTO) {
        Crianca crianca = mapCriancaRequestDTOToCrianca(criancaRequestDTO);
        Crianca savedCrianca = criancaService.createCrianca(crianca);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCrianca);
    }

    @PutMapping("/{criancaId}")
    public ResponseEntity<Crianca> updateCrianca(@PathVariable Integer criancaId, @RequestBody CriancaRequestDTO criancaRequestDTO) {
        Optional<Crianca> updatedCrianca = criancaService.updateCrianca(criancaId, criancaRequestDTO);
        return updatedCrianca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{criancaId}")
    public ResponseEntity<Void> deleteCrianca(@PathVariable Integer criancaId) {
        boolean deleted = criancaService.deleteCrianca(criancaId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Crianca mapCriancaRequestDTOToCrianca(CriancaRequestDTO criancaRequestDTO) {
        Crianca crianca = new Crianca();
        // Mapeie os atributos de CriancaRequestDTO para Crianca aqui
        crianca.setDataDeNascimento(criancaRequestDTO.getDataDeNascimento());
        crianca.setIdDefinicaoDoCabelo(criancaRequestDTO.getIdDefinicaoDoCabelo());
        crianca.setIdUsuario(criancaRequestDTO.getIdUsuario());
        crianca.setNomeCompleto(criancaRequestDTO.getNomeCompleto());
        crianca.setNomeFantasia(criancaRequestDTO.getNomeFantasia());
        crianca.setStatus(criancaRequestDTO.getStatus());
        // Adicione outros mapeamentos conforme necessário

        return crianca;
    }
}
;