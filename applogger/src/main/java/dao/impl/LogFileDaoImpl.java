package dao.impl;

import conexion.FileDB;
import dao.LogDao;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogFileDaoImpl implements LogDao {

    private static Logger logger = Logger.getLogger(String.valueOf(LogFileDaoImpl.class));

    public int save(String logText, String transaction) {

        FileHandler fh = null;

        try {

            fh = new FileHandler(FileDB.getFileStore());

            logger.addHandler(fh);
            logger.log(Level.INFO, logText);
            return 1;

        } catch (Exception ex) {
            logger.info(transaction + ex.getMessage());
        }

        return 0;

    }

    public void createTable() {

    }

}
