package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.DTO.CriancaRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.Crianca;
import br.com.afroglow.backendAfroGlow.Repository.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriancaService {
    
    @Autowired
    private CriancaRepository criancaRepository;

    public List<Crianca> getAllCriancas() {
        return criancaRepository.findAll();
    }

    public Optional<Crianca> getCriancaById(Long id) {
        return criancaRepository.findById(id);
    }

    public Crianca createCrianca(Crianca crianca) {
        return criancaRepository.save(crianca);
    }

    public Optional<Crianca> updateCrianca(Long id, CriancaRequestDTO criancaRequestDTO) {
        Optional<Crianca> existingCrianca = getCriancaById(id);
        return existingCrianca.map(crianca -> {
            mapCriancaRequestDTOToCrianca(criancaRequestDTO, crianca);
            return criancaRepository.save(crianca);
        });
    }

    public boolean deleteCrianca(Long id) {
        if (criancaRepository.existsById(id)) {
            criancaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void mapCriancaRequestDTOToCrianca(CriancaRequestDTO criancaRequestDTO, Crianca crianca) {
        // Mapeie os atributos de CriancaRequestDTO para Crianca aqui
        crianca.setDataDeNascimento(criancaRequestDTO.getDataDeNascimento());
        crianca.setIdDefinicaoDoCabelo(criancaRequestDTO.getIdDefinicaoDoCabelo());
        crianca.setIdUsuario(criancaRequestDTO.getIdUsuario());
        crianca.setNomeCompleto(criancaRequestDTO.getNomeCompleto());
        crianca.setNomeFantasia(criancaRequestDTO.getNomeFantasia());
        crianca.setStatus(criancaRequestDTO.getStatus());
   
    }
}