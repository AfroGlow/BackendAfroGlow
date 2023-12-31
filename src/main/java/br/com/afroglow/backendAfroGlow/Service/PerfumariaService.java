package br.com.afroglow.backendAfroGlow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afroglow.backendAfroGlow.Models.Perfumaria;
import br.com.afroglow.backendAfroGlow.Repository.PerfumariaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumariaService {

    private final PerfumariaRepository perfumariaRepository;

    @Autowired
    public PerfumariaService(PerfumariaRepository perfumariaRepository) {
        this.perfumariaRepository = perfumariaRepository;
    }

    public List<Perfumaria> getAllPerfumarias() {
        return perfumariaRepository.findAll();
    }

    public Optional<Perfumaria> getPerfumariaById(Long id) {
        return perfumariaRepository.findById(id);
    }

    public Perfumaria savePerfumaria(Perfumaria perfumaria) {
        return perfumariaRepository.save(perfumaria);
    }

    public void deletePerfumaria(Long id) {
        perfumariaRepository.deleteById(id);
    }
}
