package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.DefinicaoDoCabelo;
import br.com.afroglow.backendAfroGlow.Repository.DefinicaoDoCabeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefinicaoDoCabeloService {

    private final DefinicaoDoCabeloRepository definicaoDoCabeloRepository;

    @Autowired
    public DefinicaoDoCabeloService(DefinicaoDoCabeloRepository definicaoDoCabeloRepository) {
        this.definicaoDoCabeloRepository = definicaoDoCabeloRepository;
    }

    public void adicionarDefinicaoDoCabelo(DefinicaoDoCabelo definicaoDoCabelo) {
        definicaoDoCabeloRepository.save(definicaoDoCabelo);
    }

    public DefinicaoDoCabelo visualizarDefinicaoDoCabelo(Integer definicaoDoCabeloId) {
        return definicaoDoCabeloRepository.findById(definicaoDoCabeloId).orElse(null);
    }

    public void atualizarDefinicaoDoCabelo(DefinicaoDoCabelo definicaoDoCabelo) {
        definicaoDoCabeloRepository.save(definicaoDoCabelo);
    }

    public void deletarDefinicaoDoCabelo(Integer definicaoDoCabeloId) {
        definicaoDoCabeloRepository.deleteById(definicaoDoCabeloId);
    }
}
