package br.com.afroglow.backendAfroGlow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
public class Endereco {


       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;


    public Endereco() {
        this.rua = "";
        this.numero = "";
        this.bairro = "";
        this.complemento = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
    }

   
    public void adicionarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "INSERT INTO endereco (rua, bairro, numero, complemento, cidade, estado, cep ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, rua);
                statement.setString(2, bairro);
                statement.setString(3, numero);
                statement.setString(4, complemento);
                statement.setString(5, cidade);
                statement.setString(6, estado);
                statement.setString(7,cep);
                statement.executeUpdate();
                System.out.println("Endereço adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void visualizarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "SELECT rua, bairro, numero, complemento, cidade, estado, cep FROM endereco";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.rua = resultSet.getString("rua");
                    this.bairro = resultSet.getString("bairro");
                    this.numero = resultSet.getString("numero");
                    this.complemento = resultSet.getString("complemento");
                    this.cidade = resultSet.getString("cidade");
                    this.estado = resultSet.getString("estado");
                    this.cep = resultSet.getString("cep");
                } else {
                    System.out.println("Nenhum Endereço encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void atualizarEndereco() {
        try (Connection conexao = Conexao.obterConexao()) {
            String sql = "UPDATE endereco SET rua=?, bairro=?, numero=?, complemento=?, cidade=?, estado=?, cep=?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, rua);
                statement.setString(2, bairro);
                statement.setString(3, numero);
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
