package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.PedidosBox;

public class PedidosBoxController {
    private List<PedidosBox> listaDePedidosBox;

    public PedidosBoxController() {
        this.listaDePedidosBox = new ArrayList<>();
    }

    // Método para salvar um pedido de box
    public void salvarPedidoBox(PedidosBox pedidoBox) {
        listaDePedidosBox.add(pedidoBox);
        // Lógica adicional, como salvar no banco de dados, pode ser adicionada aqui
    }

    // Método para buscar todos os pedidos de box
    public List<PedidosBox> buscarTodosPedidosBox() {
        return listaDePedidosBox;
    }

    // Método para buscar um pedido de box por ID
    public PedidosBox buscarPedidoBoxPorId(int idPedidosBox) {
        for (PedidosBox pedidoBox : listaDePedidosBox) {
            if (pedidoBox.getIdPedidosBox() == idPedidosBox) {
                return pedidoBox;
            }
        }
        return null; // Retorna null se não encontrar o pedido de box
    }

    // Outros métodos conforme necessário...

    // Exemplo de método para atualizar o ID do pagamento de um pedido de box
    public void atualizarIdPagamentoPedidoBox(int idPedidosBox, int novoIdPagamento) {
        for (PedidosBox pedidoBox : listaDePedidosBox) {
            if (pedidoBox.getIdPedidosBox() == idPedidosBox) {
                pedidoBox.setIdPagamento(novoIdPagamento);
                // Lógica adicional, como atualizar no banco de dados, pode ser adicionada aqui
                return;
            }
        }
        // Pode lançar uma exceção ou lidar de outra forma se o pedido de box não for encontrado
    }

    // Exemplo de método para deletar um pedido de box
    public void deletarPedidoBox(int idPedidosBox) {
        listaDePedidosBox.removeIf(pedidoBox -> pedidoBox.getIdPedidosBox() == idPedidosBox);
      
    }
}