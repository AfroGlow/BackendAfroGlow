package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.TipoDeUsuario;
import br.com.afroglow.backendAfroGlow.Repository.TipoDeUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeUsuarioService {

    private final TipoDeUsuarioRepository tipoDeUsuarioRepository;

    @Autowired
    public TipoDeUsuarioService(TipoDeUsuarioRepository tipoDeUsuarioRepository) {
        this.tipoDeUsuarioRepository = tipoDeUsuarioRepository;
    }

    public void adicionarTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        tipoDeUsuarioRepository.save(tipoDeUsuario);
    }

    public List<TipoDeUsuario> visualizarTiposDeUsuario() {
        return tipoDeUsuarioRepository.findAll();
    }

    public void atualizarTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        tipoDeUsuarioRepository.save(tipoDeUsuario);
    }

    // public void deletarTipoDeUsuario(String descricao) {
    //     tipoDeUsuarioRepository.deleteById(descricao);
    // }

    // public String getTipoDeUsuario(String descricao) {
    //     TipoDeUsuario tipoDeUsuario = tipoDeUsuarioRepository.findById(descricao).orElse(null);
    //     if (tipoDeUsuario != null) {
    //         return tipoDeUsuario.toString();
    //     } else {
    //         return "Tipo de usuário não encontrado.";
    //     }
    // }

    public TipoDeUsuario visualizarTipoDeUsuario(String descricao) {
        return null;
    }
}
