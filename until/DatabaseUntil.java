/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DatabaseUntil {
    final static String DRIVER = ResourceBundle.getBundle("db").getString("driver");
    final static String SEVER = ResourceBundle.getBundle("db").getString("sever");
    final static String USERNAME = ResourceBundle.getBundle("db").getString("username");
    final static String PASSWORD = ResourceBundle.getBundle("db").getString("password");

    private DatabaseUntil() {
    }
    
    public static Connection connection() {
        Connection con = null;
        
        try {
            
            Class.forName(DRIVER);
            System.out.println("Driver loaded.");
            con = DriverManager.getConnection(SEVER, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseUntil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    
    public static void close(Connection...connections) {
        if (connections == null) {
            return;
        }
        
        for (Connection con : connections) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUntil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void close(PreparedStatement...preparedStatements) {
        if (preparedStatements == null) {
            return;
        }
        
        for (PreparedStatement pstm : preparedStatements) {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUntil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void close(ResultSet...resultSets) {
        if (resultSets == null) {
            return;
        }
        
        for (ResultSet rs : resultSets) {
            try {
                rs.close();
                System.out.println("ResultSet closed.");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUntil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
