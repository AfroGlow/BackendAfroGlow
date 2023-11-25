package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.TipoDeCabelo;

public class TipoDeCabeloController {
    private List<TipoDeCabelo> listaDeTiposDeCabelo;

    public TipoDeCabeloController() {
        this.listaDeTiposDeCabelo = new ArrayList<>();
    }

    // Método para salvar um tipo de cabelo
    public void salvarTipoDeCabelo(TipoDeCabelo tipoDeCabelo) {
        listaDeTiposDeCabelo.add(tipoDeCabelo);
        // Lógica adicional, como salvar no banco de dados, pode ser adicionada aqui
    }

    // Método para buscar todos os tipos de cabelo
    public List<TipoDeCabelo> buscarTodosTiposDeCabelo() {
        return listaDeTiposDeCabelo;
    }

    // Método para buscar um tipo de cabelo por ID
    public TipoDeCabelo buscarTipoDeCabeloPorId(int idTipoDeCabelo) {
        for (TipoDeCabelo tipoDeCabelo : listaDeTiposDeCabelo) {
            if (tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo) {
                return tipoDeCabelo;
            }
        }
        return null; // Retorna null se não encontrar o tipo de cabelo
    }

    // Outros métodos conforme necessário...

    // Exemplo de método para atualizar a curvatura do cabelo
    public void atualizarCurvaturaDoCabelo(int idTipoDeCabelo, String novaCurvatura) {
        for (TipoDeCabelo tipoDeCabelo : listaDeTiposDeCabelo) {
            if (tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo) {
                tipoDeCabelo.setCurvaturaDoCabelo(novaCurvatura);
                // Lógica adicional, como atualizar no banco de dados, pode ser adicionada aqui
                return;
            }
        }
        // Pode lançar uma exceção ou lidar de outra forma se o tipo de cabelo não for encontrado
    }

    // Exemplo de método para deletar um tipo de cabelo
    public void deletarTipoDeCabelo(int idTipoDeCabelo) {
        listaDeTiposDeCabelo.removeIf(tipoDeCabelo -> tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo);
      
    }
}