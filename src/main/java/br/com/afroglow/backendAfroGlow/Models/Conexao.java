package br.com.afroglow.backendAfroGlow.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // URL de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3307/bdafroglow";
    private static final String USUARIO = "root";
    private static final String SENHA = "MySQL@2022";

    // Método para obter uma conexão com o banco de dados
    public static Connection obterConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não encontrado", e);
        }
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

