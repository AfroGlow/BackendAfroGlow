package br.com.afroglow.backendAfroGlow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afroglow.backendAfroGlow.Controllers.BoxRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.Box;
import br.com.afroglow.backendAfroGlow.Repository.BoxRepository;

import java.util.List;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }

    public Box getBoxById(Long id) {
        return boxRepository.findById(id).orElse(null);
    }

    public Box createBox(BoxRequestDTO boxRequestDTO) {
        Box box = new Box(boxRequestDTO);
        return boxRepository.save(box);
    }

    public Box updateBox(Long id, BoxRequestDTO boxRequestDTO) {
        Box existingBox = boxRepository.findById(id).orElse(null);
        if (existingBox != null) {
            existingBox.setTipoDeBox(boxRequestDTO.getTipoDeBox());
            existingBox.setPreco(boxRequestDTO.getPreco());
            existingBox.setQtdDeProdutos((Integer) boxRequestDTO.getQtdDeProdutos());
            return boxRepository.save(existingBox);
        }
        return null;
    }

    public void deleteBox(Long id) {
        boxRepository.deleteById(id);
    }
}