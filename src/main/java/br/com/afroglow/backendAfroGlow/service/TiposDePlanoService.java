package br.com.afroglow.backendAfroGlow.service;


// import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.TiposDePlano;

public class TiposDePlanoService {
    public TiposDePlano buscaTiposDePlano(Integer tipoDePlanosId) {
        TiposDePlano tiposDePlano = new TiposDePlano();
        tiposDePlano.idTiposDePlano = 3;
        tiposDePlano.nomeDoPlano = "Rato";
        // tiposDePlano.preco = 9.99(ARRUMAR);
        tiposDePlano.duracao = "3 meses";
        tiposDePlano.descricao = "pipipipopopo";
        return tiposDePlano;
}
        //     public List<TiposDePlano>retornarListaDeTiposDePlanos(){
// }
    
    public void adicionarTipoDePlano(TiposDePlano tipoDePlano) { 

    }

    public void deletarTipoDePlano(Integer tipoDePlanoId) {

    }

    public void atualizarTiposDePlano(TiposDePlano tiposDePlano){

    }
}


