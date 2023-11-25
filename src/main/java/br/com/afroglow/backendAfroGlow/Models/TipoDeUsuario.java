package br.com.afroglow.backendAfroGlow.Models;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class TipoDeUsuario {

    private String descricao;

    // Construtor que inicializa os atributos com valores padrão
    public TipoDeUsuario() {
        this.descricao = "";
    }

    // Método para adicionar uma descrição no banco de dados
    public void adicionarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "INSERT INTO tipodeusuario (descricao) VALUES (?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, descricao);
                statement.executeUpdate();
                System.out.println("Descrição adicionada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para visualizar a descrição a partir do banco de dados
    public void visualizarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "SELECT descricao FROM tipodeusuario";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.descricao = resultSet.getString("descricao");
                } else {
                    System.out.println("Nenhuma Descrição encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar a descrição no banco de dados
    public void atualizarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "UPDATE tipodeusuario SET descricao=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, descricao);
                statement.executeUpdate();
                System.out.println("Descrição atualizada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar a descrição do banco de dados
    public void deletarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "DELETE FROM tipodeusuario WHERE descricao=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, descricao);
                statement.executeUpdate();
                System.out.println("Descrição deletada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
