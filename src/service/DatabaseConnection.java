package service;

import contantes.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton ne peut etre instanciée qu'1 SEULE fois
public class DatabaseConnection {
    private static Connection connection;
    final private static String URL = Constantes.URL;
    final private static String USERNAME = Constantes.USERNAME;
    final private static String PASSWORD = Constantes.PASSWORD;

    private DatabaseConnection() {
    }

    // Charge le driver et verifie si il existe une instance
    public static Connection getInstance() throws SQLException {
        try {
            if (connection == null) {
                // Ouverture de la connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("connexion établie avec succès");
            }
            return connection;
        } catch (SQLException e) {
            throw new SQLException("Connection database échouéé");
        }
        //  return null;
    }
}
