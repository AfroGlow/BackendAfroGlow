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

    @GetMapping("/{pedidoBoxId}")
    public ResponseEntity<PedidoBox> getPedidoBoxById(@PathVariable Integer pedidoBoxId) {
        Optional<PedidoBox> pedidoBox = pedidoBoxService.getPedidoBoxById(pedidoBoxId);
        return pedidoBox.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidoBox> createPedidoBox(@RequestBody PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        PedidoBox pedidoBox = pedidoBoxService.createPedidoBox(pedidoBoxRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoBox);
    }

    @PutMapping("/{pedidoBoxId}")
    public ResponseEntity<PedidoBox> updatePedidoBox(@PathVariable Integer pedidoBoxId, @RequestBody PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        Optional<PedidoBox> updatedPedidoBox = pedidoBoxService.updatePedidoBox(pedidoBoxId, pedidoBoxRequestDTO);
        return updatedPedidoBox.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{pedidoBoxId}")
    public ResponseEntity<Void> deletePedidoBox(@PathVariable Integer pedidoBoxId) {
        boolean deleted = pedidoBoxService.deletePedidoBox(pedidoBoxId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}