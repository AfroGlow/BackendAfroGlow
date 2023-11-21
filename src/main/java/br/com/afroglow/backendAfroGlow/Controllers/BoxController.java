package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.Box;

public class BoxController {
    private List<Box> listaDeBoxes;

    public BoxController() {
        this.listaDeBoxes = new ArrayList<>();
    }

    // Método para salvar um box
    public void salvarBox(Box box) {
        listaDeBoxes.add(box);
        // Lógica adicional, como salvar no banco de dados, pode ser adicionada aqui
    }

    // Método para buscar todos os boxes
    public List<Box> buscarTodosBoxes() {
        return listaDeBoxes;
    }

    // Método para buscar um box pelo tipo
    public Box buscarBoxPorTipo(int tipoDeBox) {
        for (Box box : listaDeBoxes) {
            if (box.getTipoDeBox() == tipoDeBox) {
                return box;
            }
        }
        return null; // Retorna null se não encontrar o box
    }

    // Outros métodos conforme necessário...

    // Exemplo de método para atualizar o preço de um box
    public void atualizarPrecoBox(int tipoDeBox, double novoPreco) {
        for (Box box : listaDeBoxes) {
            if (box.getTipoDeBox() == tipoDeBox) {
                box.setPreco(novoPreco);
                // Lógica adicional, como atualizar no banco de dados, pode ser adicionada aqui
                return;
            }
        }
        // Pode lançar uma exceção ou lidar de outra forma se o box não for encontrado
    }

    // Exemplo de método para deletar um box
    public void deletarBox(int tipoDeBox) {
        listaDeBoxes.removeIf(box -> box.getTipoDeBox() == tipoDeBox);
        // Lógica adicional, como deletar do banco de dados, pode ser adicionada aqui
    }
}

