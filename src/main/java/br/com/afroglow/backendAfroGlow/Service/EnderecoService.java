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

    public void deletarEndereco(Integer enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }

    public String getEndereco(Integer enderecoId) {
        Endereco endereco = enderecoRepository.findById(enderecoId).orElse(null);
        if (endereco != null) {
            return endereco.toString();
        } else {
            return "Endereço não encontrado.";
        }
    }

    public Endereco visualizarEndereco(Integer enderecoId) {
        return null;
    }
}
