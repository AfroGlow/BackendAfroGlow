package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.Endereco;
import br.com.afroglow.backendAfroGlow.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public List<Endereco> visualizarEnderecos() {
        return enderecoRepository.findAll();
    }

    public void atualizarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public String getEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        if (endereco != null) {
            return endereco.toString();
        } else {
            return "Endereço não encontrado.";
        }
    }

    public Endereco visualizarEndereco(Long enderecoId) {
        return null;
    }
}
