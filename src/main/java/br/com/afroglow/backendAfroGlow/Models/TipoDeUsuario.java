package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
public class TipoDeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipodeusuario;

    private String descricao;

    // Construtor que inicializa os atributos com valores padrão
    public TipoDeUsuario() {
        this.descricao = "";
    }

    // Métodos JPA para persistência
    public Integer getIdtipodeusuario() {
        return idtipodeusuario;
    }

    public void setIdtipodeusuario(Integer idtipodeusuario) {
        this.idtipodeusuario = idtipodeusuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
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

 
    public void visualizarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "SELECT idtipodeusuario, descricao FROM tipodeusuario";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.idtipodeusuario = resultSet.getInt("idtipodeusuario");
                    this.descricao = resultSet.getString("descricao");
                } else {
                    System.out.println("Nenhuma Descrição encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void atualizarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "UPDATE tipodeusuario SET descricao=? WHERE idtipodeusuario=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, descricao);
                statement.setInt(2, idtipodeusuario);
                statement.executeUpdate();
                System.out.println("Descrição atualizada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deletarDescricao() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "DELETE FROM tipodeusuario WHERE idtipodeusuario=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idtipodeusuario);
                statement.executeUpdate();
                System.out.println("Descrição deletada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
