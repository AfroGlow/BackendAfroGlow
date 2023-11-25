package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.Box;
import br.com.afroglow.backendAfroGlow.Repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> listarBoxes() {
        return boxRepository.findAll();
    }

    public Box obterBox(Long id) {
        return boxRepository.findById(id).orElse(null);
    }

    public Box salvarBox(Box box) {
        return boxRepository.save(box);
    }

    public void deletarBox(Long id) {
        boxRepository.deleteById(id);
    }
}