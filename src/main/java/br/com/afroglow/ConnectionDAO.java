package br.com.afroglow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionDAO {
    public Connection conectaBD(){
        Connection conn = null;

        try {
        String url = "jdbc:mysql://localhost:3306/dbafroglow?user=admin&password=admin123";
        conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
}
