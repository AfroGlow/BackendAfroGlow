package br.com.afroglow.backendAfroGlow.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

    // Construtor que inicializa os atributos com valores padrão
    public Endereco() {
        this.rua = "";
        this.numero = "";
        this.bairro = "";
        this.complemento = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
    }

    // Método para estabelecer a conexão com o banco de dados SQLite
    private Connection conectar() throws SQLException {
        String url = "jdbc:sqlite://localhost:3307/bdafroglow";
        return DriverManager.getConnection(url);
    }

    // Método para adicionar um endereço no banco de dados
    public void adicionarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "INSERT INTO endereco (rua, numero, bairro, complemento, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, rua);
                statement.setString(2, numero);
                statement.setString(3, bairro);
                statement.setString(4, complemento);
                statement.setString(5, cidade);
                statement.setString(6, estado);
                statement.setString(7, cep);
                statement.executeUpdate();
                System.out.println("Endereço adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para visualizar o endereço a partir do banco de dados
    public void visualizarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "SELECT rua, numero, bairro, complemento, cidade, estado, cep FROM endereco";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.rua = resultSet.getString("rua");
                    this.numero = resultSet.getString("numero");
                    this.bairro = resultSet.getString("bairro");
                    this.complemento = resultSet.getString("complemento");
                    this.cidade = resultSet.getString("cidade");
                    this.estado = resultSet.getString("estado");
                    this.cep = resultSet.getString("cep");
                } else {
                    System.out.println("Nenhum endereço encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar o endereço no banco de dados
    public void atualizarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "UPDATE endereco SET rua=?, numero=?, bairro=?, complemento=?, cidade=?, estado=?, cep=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, rua);
                statement.setString(2, numero);
                statement.setString(3, bairro);
                statement.setString(4, complemento);
                statement.setString(5, cidade);
                statement.setString(6, estado);
                statement.setString(7, cep);
                statement.executeUpdate();
                System.out.println("Endereço atualizado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar o endereço do banco de dados
    public void deletarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "DELETE FROM endereco";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.executeUpdate();
                System.out.println("Endereço deletado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarEndereco(String rua2, String cidade2, String estado2, String cep2) {
    }

    public void atualizarEndereco(String rua2, String cidade2, String estado2, String cep2) {
    }
}
