package conexion;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static Logger logger = Logger.getLogger(String.valueOf(ConexionDB.class));
    private static Connection connection;

    private ConexionDB() {

        Properties properties = null;
        InputStream inputStreamConfig = null;

        try {

            inputStreamConfig = new FileInputStream("database.properties");
            properties = new Properties();

            properties.load(inputStreamConfig);

            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(properties.getProperty("URL"), properties);

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    public static void closeConnetion(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static Connection getConnection() {

        if (connection == null) {
            new ConexionDB();
        }
        return connection;

    }

}
