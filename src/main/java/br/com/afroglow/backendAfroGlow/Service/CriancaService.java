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

    public Optional<Crianca> getCriancaById(Integer criancaId) {
        return criancaRepository.findById(criancaId);
    }

    public Crianca createCrianca(Crianca crianca) {
        return criancaRepository.save(crianca);
    }

    public Optional<Crianca> updateCrianca(Integer criancaId, CriancaRequestDTO criancaRequestDTO) {
        Optional<Crianca> existingCrianca = getCriancaById(criancaId);
        return existingCrianca.map(crianca -> {
            mapCriancaRequestDTOToCrianca(criancaRequestDTO, crianca);
            return criancaRepository.save(crianca);
        });
    }

    public boolean deleteCrianca(Integer criancaId) {
        if (criancaRepository.existsById(criancaId)) {
            criancaRepository.deleteById(criancaId);
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