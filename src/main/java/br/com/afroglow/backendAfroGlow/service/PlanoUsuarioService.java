package br.com.afroglow.backendAfroGlow.Service;

// import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;

public class PlanoUsuarioService {
    public PlanoUsuario buscaPlanoUsuario(Integer planoUsuarioId){
        PlanoUsuario planoUsuarios = new PlanoUsuario();
        planoUsuarios.idPlanoUsuario = 2;
        planoUsuarios.idUsuario = 8;
        planoUsuarios.idPlanoUsuario = 7;
        planoUsuarios.statusPagamento = "Não mim pagarão";
        return planoUsuarios;
    }

    // public List<PlanoUsuarios>retornarListaPlanoUsuarios(){
    //     return List<PlanoUsuarios>();
    // }

    public void adicionarPlanoUsuario(PlanoUsuario planoUsuario){
        
    }

    public void deletarPlanoUsuario(Integer planoUsuarioId){

    }

    public void atualizarPlanoUsuario(PlanoUsuario planoUsuario){

    }

    public PlanoUsuario buscaPlanoUsuarios(Integer planoUsuariosId) {
        return null;
    }
}
