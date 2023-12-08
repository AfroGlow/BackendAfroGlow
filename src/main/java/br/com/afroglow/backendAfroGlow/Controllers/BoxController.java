package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.afroglow.backendAfroGlow.Models.Box;
import br.com.afroglow.backendAfroGlow.Repository.BoxRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BoxController {
    @Autowired
    private BoxRepository boxRepository;

    @GetMapping
    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }

    @GetMapping("/{boxId}")
    public ResponseEntity<Box> getBoxById(@PathVariable Integer boxId) {
        Optional<Box> box = boxRepository.findById(boxId);
        return box.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Box> createBox(@RequestBody Box box) {
        Box savedBox = boxRepository.save(box);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBox);
    }

    @PutMapping
    public ResponseEntity<Box> updateBox(@PathVariable Integer boxId, @RequestBody Box updatedBox) {
        if (!boxRepository.existsById(boxId)) {
            return ResponseEntity.notFound().build();
        }

        updatedBox.setIdBox(boxId);
        Box savedBox = boxRepository.save(updatedBox);
        return ResponseEntity.ok(savedBox);
    }

    @DeleteMapping("/{boxId}")
    public ResponseEntity<Void> deleteBox(@PathVariable Integer boxId) {
        if (!boxRepository.existsById(boxId)) {
            return ResponseEntity.notFound().build();
        }
        boxRepository.deleteById(boxId);
        return ResponseEntity.noContent().build();
    }
}
