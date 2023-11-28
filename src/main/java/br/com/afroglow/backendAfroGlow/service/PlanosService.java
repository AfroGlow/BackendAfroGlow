package br.com.afroglow.backendAfroGlow.Service;


// import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.Planos;

public class PlanosService {
    public Planos buscaPlanos(Integer planosId) {
        Planos planos = new Planos();
        planos.idPlano = 3;
        planos.nomeDoPlano = "Rato";
        // planoUsuario.preco = 9.99(ARRUMAR);
        planos.duracao = "3 meses";
        planos.descricao = "pipipipopopo";
        return planos;
}
        //     public List<PlanoUsuario>retornarListaDePlanoUsuarios(){
// }
    
    public void adicionarTipoDePlano(Planos planoUsuario) { 

    }

    public void deletarTipoDePlano(Integer planoUsuarioId) {

    }

    public void atualizarPlanoUsuario(Planos planoUsuario){

    }
}


