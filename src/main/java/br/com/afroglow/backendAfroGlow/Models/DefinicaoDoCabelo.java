package br.com.afroglow.backendAfroGlow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Entity
public class DefinicaoDoCabelo {
    
    @Id
    private String idDefinicaoDoCabelo;
    private String definicao;

    public DefinicaoDoCabelo(){
        this.idDefinicaoDoCabelo = "";
        this.definicao = "";
    }

    public void adcionarDefinicaoDoCabelo(){
        try(Connection conexao = Conexao.obterConexao()){
            String sql = "INSERT INTO definicaodocabelo (idDefinicaoDoCabelo, definicao) VALUES (?, ?)";
            try(PreparedStatement statement = conexao.prepareStatement(sql)){
                statement.setString(1, idDefinicaoDoCabelo);
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
                statement.setString(2, idDefinicaoDoCabelo);
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
                statement.setString(1, idDefinicaoDoCabelo);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIdDefinicaoDoCabelo(){
        return idDefinicaoDoCabelo;
    }

    public void setIdDefinicaoDoCabelo(String idDefinicaoDoCabelo){
        this.idDefinicaoDoCabelo = idDefinicaoDoCabelo;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }
}
