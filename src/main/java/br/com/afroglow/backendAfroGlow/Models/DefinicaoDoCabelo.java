package br.com.afroglow.backendAfroGlow.Models;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Entity
public class DefinicaoDoCabelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String definicao;

    public DefinicaoDoCabelo() {
        this.id = null; 
        this.definicao = "";
    }

    public void adcionarDefinicaoDoCabelo(){
        try(Connection conexao = Conexao.obterConexao()){
            String sql = "INSERT INTO definicaodocabelo (idDefinicaoDoCabelo, definicao) VALUES (?, ?)";
            try(PreparedStatement statement = conexao.prepareStatement(sql)){
                statement.setLong(1, id);
                statement.setString(2, definicao);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public void editarDefinicaoDoCabelo(){
        try(Connection conexao = Conexao.obterConexao()){
            String sql = "UPDATE definicaodocabelo SET definicao=? WHERE idDefinicaoDoCabelo=?";
            try(PreparedStatement statement = conexao.prepareStatement(sql)){
                statement.setString(1, definicao);
                statement.setLong(2, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirDefinicaoDoCabelo(){
        try(Connection conexao = Conexao.obterConexao()){
            String sql = "DELETE FROM definicaodocabelo WHERE idDefinicaoDoCabelo=?";
            try(PreparedStatement statement = conexao.prepareStatement(sql)){
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getIdDefinicaoDoCabelo(){
        return id;
    }

    public void setIdDefinicaoDoCabelo(Long idDefinicaoDoCabelo){
        this.id = idDefinicaoDoCabelo;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }
}
