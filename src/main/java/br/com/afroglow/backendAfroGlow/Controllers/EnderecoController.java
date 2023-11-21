package br.com.afroglow.backendAfroGlow.Controllers;


import com.google.gson.Gson;

import br.com.afroglow.backendAfroGlow.Models.Endereco;
import spark.Request;
import spark.Response;
import static spark.Spark.*;


public class EnderecoController {

    private final Endereco endereco;

    public EnderecoController(Endereco endereco) {
        this.endereco = endereco;
        configurarRotas();
    }

    private void configurarRotas() {
        // Rota para adicionar um endereço
        post("/endereco", (request, response) -> adicionarEndereco(request, response), new Gson()::toJson);

        // Rota para visualizar o endereço
        get("/endereco", (request, response) -> visualizarEndereco(request, response), new Gson()::toJson);

        // Rota para atualizar o endereço
        put("/endereco", (request, response) -> atualizarEndereco(request, response), new Gson()::toJson);

        // Rota para deletar o endereço
        delete("/endereco", (request, response) -> deletarEndereco(request, response), new Gson()::toJson);
    }

    private String adicionarEndereco(Request request, Response response) {
        EnderecoRequest enderecoRequest = new Gson().fromJson(request.body(), EnderecoRequest.class);
        endereco.adicionarEndereco(enderecoRequest.rua, enderecoRequest.cidade, enderecoRequest.estado, enderecoRequest.cep);
        response.status(201); // Código de status 201 para indicar que o recurso foi criado
        return "Endereço adicionado com sucesso!";
    }

    private String visualizarEndereco(Request request, Response response) {
        endereco.visualizarEndereco();
        return new Gson().toJson(endereco);
    }

    private String atualizarEndereco(Request request, Response response) {
        EnderecoRequest enderecoRequest = new Gson().fromJson(request.body(), EnderecoRequest.class);
        endereco.atualizarEndereco(enderecoRequest.rua, enderecoRequest.cidade, enderecoRequest.estado, enderecoRequest.cep);
        return "Endereço atualizado com sucesso!";
    }

    private String deletarEndereco(Request request, Response response) {
        endereco.deletarEndereco();
        return "Endereço deletado com sucesso!";
    }

    // Classe auxiliar para a requisição JSON
    private static class EnderecoRequest {
        String rua;
        String cidade;
        String estado;
        String cep;
    }

    public static void main(String[] args) {
        new EnderecoController(new Endereco());
    }
}
