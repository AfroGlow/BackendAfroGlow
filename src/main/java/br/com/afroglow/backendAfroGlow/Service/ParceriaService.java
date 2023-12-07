package br.com.afroglow.backendAfroGlow.Service;



import br.com.afroglow.backendAfroGlow.Models.Parceria;
import br.com.afroglow.backendAfroGlow.Repository.ParceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParceriaService {

    @Autowired
    private ParceriaRepository parceriaRepository;

    public List<Parceria> listarParcerias() {
        return parceriaRepository.findAll();
    }

    public Optional<Parceria> obterParceriaPorId(Long id) {
        return parceriaRepository.findById(id);
    }

    public Parceria salvarParceria(Parceria parceria) {
        return parceriaRepository.save(parceria);
    }

    public void excluirParceria(Long id) {
        parceriaRepository.deleteById(id);
    }
}
