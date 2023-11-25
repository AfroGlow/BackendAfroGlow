package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.TipoDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDeUsuarioService {

    private final TipoDeUsuario tipoDeUsuario;

    @Autowired
    public TipoDeUsuarioService(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public void adicionarDescricao() {
        tipoDeUsuario.adicionarDescricao();
    }

    public void visualizarDescricao() {
        tipoDeUsuario.visualizarDescricao();
    }

    public void atualizarDescricao() {
        tipoDeUsuario.atualizarDescricao();
    }

    public void deletarDescricao() {
        tipoDeUsuario.deletarDescricao();
    }

    public String getDescricao() {
        return tipoDeUsuario.getDescricao();
    }
}
