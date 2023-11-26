package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
public class Admin {

    @Id
    private Integer idAdmin;
    private String nomeAdmin;
    private String senha;
    private String dataDeNascimento;
    private String email;

    // Construtor que inicializa os atributos com valores padrão
    public Admin() {
        this.idAdmin = 0;
        this.nomeAdmin = "";
        this.senha = "";
        this.dataDeNascimento = "";
        this.email = "";
    }

    // Método para adicionar um administrador no banco de dados
    public void adicionarAdmin() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "INSERT INTO administrador (idAdmin, nomeAdmin, senha, dataDeNascimento, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idAdmin);
                statement.setString(2, nomeAdmin);
                statement.setString(3, senha);
                statement.setString(4, dataDeNascimento);
                statement.setString(5, email);
                statement.executeUpdate();
                System.out.println("Admin adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para visualizar o administrador a partir do banco de dados
    public void visualizarAdmin() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "SELECT nomeAdmin, senha, dataDeNascimento, email FROM administrador WHERE idAdmin=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idAdmin);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.nomeAdmin = resultSet.getString("nomeAdmin");
                    this.senha = resultSet.getString("senha");
                    this.dataDeNascimento = resultSet.getString("dataDeNascimento");
                    this.email = resultSet.getString("email");
                } else {
                    System.out.println("Nenhum Admin encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar o administrador no banco de dados
    public void atualizarAdmin() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "UPDATE administrador SET nomeAdmin=?, senha=?, dataDeNascimento=?, email=? WHERE idAdmin=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, nomeAdmin);
                statement.setString(2, senha);
                statement.setString(3, dataDeNascimento);
                statement.setString(4, email);
                statement.setInt(5, idAdmin);
                statement.executeUpdate();
                System.out.println("Admin atualizado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
