package dao;

import conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface LogDao {

    int save(String logText, String transaction);

    void createTable();

}
