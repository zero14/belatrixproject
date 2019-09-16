package dao.impl;

import conexion.ConexionDB;
import dao.LogDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDbDaoImpl implements LogDao {

    private static Logger logger = Logger.getLogger(String.valueOf(LogDbDaoImpl.class));

    public int save(String logText, String transaction) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            createTable();

            connection = ConexionDB.getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO Log_Values(value)VALUES(?)");
            preparedStatement.setString(1, logText);

            logger.log(Level.INFO, logText);
            logger.log(Level.INFO, transaction + "saved record");

            return preparedStatement.executeUpdate();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, transaction + ex.getMessage());
            return 0;
        } finally {
            ConexionDB.closeConnetion(connection);
            ConexionDB.closePreparedStatement(preparedStatement);
        }
    }

    public void createTable() {
        Connection connection = null;
        Statement statement = null;

        try {

            connection = ConexionDB.getConnection();

            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS Log_Values(id BIGINT AUTO_INCREMENT,value VARCHAR(500),PRIMARY KEY (id))";
            statement.executeUpdate(sql);
            logger.info("database created");

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        } finally {
            ConexionDB.closeConnetion(connection);
            ConexionDB.closeStatement(statement);
        }

    }
}
