package br.com.afroglow.backendAfroGlow.Controllers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.com.afroglow.backendAfroGlow.Models.Crianca;

public class CriancaController {
  
    private List<Crianca> listaDeCriancas;

    public CriancaController() {
        this.listaDeCriancas = new ArrayList<>();
    }

    // Método para salvar uma criança
    public void salvarCrianca(Crianca crianca) {
        listaDeCriancas.add(crianca);
    
    }

    // Método para buscar todas as crianças
    public List<Crianca> buscarTodasCriancas() {
        return listaDeCriancas;
    }

    // Método para buscar uma criança por nome completo
    public Crianca buscarCriancaPorNomeCompleto(String nomeCompleto) {
        for (Crianca crianca : listaDeCriancas) {
            if (crianca.getNomeCompleto().equals(nomeCompleto)) {
                return crianca;
            }
        }
        return null; // Retorna null se não encontrar a criança
    }




    public void atualizarStatusCrianca(String nomeCompleto, String novoStatus) {
        for (Crianca crianca : listaDeCriancas) {
            if (crianca.getNomeCompleto().equals(nomeCompleto)) {
                crianca.setStatus(novoStatus);
             
                return;
            }
        }

    }

    // Exemplo de método para deletar uma criança
    public void deletarCrianca(String nomeCompleto) {
        listaDeCriancas.removeIf(crianca -> crianca.getNomeCompleto().equals(nomeCompleto));
      
    }
}