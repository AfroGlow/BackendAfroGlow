package br.com.afroglow.backendAfroGlow.service;

// import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.Planos;

public class PlanosService {
    public Planos buscaPlano(Integer planosId){
        Planos planos = new Planos();
        planos.idPlano = 2;
        planos.idUsuario = 8;
        planos.idTipoDePlano = 7;
        planos.statusPagamento = "Não mim pagarão";
        return planos;
    }

    // public List<Planos>retornarListaPlanos(){
    //     return List<Planos>();
    // }

    public void adicionarPlano(Planos plano){
        
    }

    public void deletarPlano(Integer planoId){

    }

    public void atualizarPlano(Planos plano){

    }

    public Planos buscaPlanos(Integer planosId) {
        return null;
    }
}
