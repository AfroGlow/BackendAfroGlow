package br.com.afroglow.backendAfroGlow.Controllers;

import br.com.afroglow.backendAfroGlow.DTO.PedidoBoxRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.PedidoBox;
import br.com.afroglow.backendAfroGlow.Service.PedidoBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidosbox")
@CrossOrigin(origins = "*")
public class PedidoBoxController {

    @Autowired
    private PedidoBoxService pedidoBoxService;

    @GetMapping
    public List<PedidoBox> getAllPedidosBox() {
        return pedidoBoxService.getAllPedidosBox();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoBox> getPedidoBoxById(@PathVariable Long id) {
        Optional<PedidoBox> pedidoBox = pedidoBoxService.getPedidoBoxById(id);
        return pedidoBox.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidoBox> createPedidoBox(@RequestBody PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        PedidoBox pedidoBox = pedidoBoxService.createPedidoBox(pedidoBoxRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoBox);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoBox> updatePedidoBox(@PathVariable Long id, @RequestBody PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        Optional<PedidoBox> updatedPedidoBox = pedidoBoxService.updatePedidoBox(id, pedidoBoxRequestDTO);
        return updatedPedidoBox.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidoBox(@PathVariable Long id) {
        boolean deleted = pedidoBoxService.deletePedidoBox(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}