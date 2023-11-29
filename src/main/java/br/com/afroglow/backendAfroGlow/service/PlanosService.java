package br.com.afroglow.backendAfroGlow.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.Planos;
import br.com.afroglow.backendAfroGlow.Repository.PlanosRepository;

@Service
public class PlanosService {
    private final PlanosRepository planosRepository;

    // Construtor da classe
    @Autowired
    public PlanosService(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }

    public Optional<Planos> buscaPlanos(Integer planosId) {
        Optional<Planos> planos = planosRepository.findById(planosId);
        // planos.idPlano = 3;
        // planos.nomeDoPlano = "Rato";
        // // planoUsuario.preco = 9.99(ARRUMAR);
        // planos.duracao = "3 meses";
        // planos.descricao = "pipipipopopo";
        return planos;
    }

    public List<Planos> retornarListaDePlanos() {
        return planosRepository.findAll();
    }

    public void adicionarTipoDePlano(Planos planos) {
        planosRepository.save(planos);
    }

    public void deletarTipoDePlano(Integer planosId) {
        planosRepository.deleteById(planosId);
    }

    public void atualizarPlanos(Planos planos) {
        planosRepository.save(planos);
    }
}