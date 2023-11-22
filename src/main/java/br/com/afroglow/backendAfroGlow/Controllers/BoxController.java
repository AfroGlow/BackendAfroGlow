package br.com.afroglow.backendAfroGlow.Controllers;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.Box;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {

    private List<Box> listaDeBoxes;

    public BoxController() {
        this.listaDeBoxes = new ArrayList<>();
    }

    // Método para salvar um box
    @PostMapping("/salvar")
    public void salvarBox(@RequestBody Box box) {
        listaDeBoxes.add(box);
       
    }

    // Método para buscar todos os boxes
    @GetMapping("/todos")
    public List<Box> buscarTodosBoxes() {
        return listaDeBoxes;
    }

    // Método para buscar um box pelo tipo
    @GetMapping("/buscarPorTipo/{tipoDeBox}")
    public Box buscarBoxPorTipo(@PathVariable int tipoDeBox) {
        for (Box box : listaDeBoxes) {
            if (box.getTipoDeBox() == tipoDeBox) {
                return box;
            }
        }
        return null; // Retorna null se não encontrar o box
    }

    // Outros métodos conforme necessário...

    // Exemplo de método para atualizar o preço de um box
    @PutMapping("/atualizarPreco/{tipoDeBox}")
    public void atualizarPrecoBox(@PathVariable int tipoDeBox, @RequestParam double novoPreco) {
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
    @DeleteMapping("/deletar/{tipoDeBox}")
    public void deletarBox(@PathVariable int tipoDeBox) {
        listaDeBoxes.removeIf(box -> box.getTipoDeBox() == tipoDeBox);
        // Lógica adicional, como deletar do banco de dados, pode ser adicionada aqui
    }
}