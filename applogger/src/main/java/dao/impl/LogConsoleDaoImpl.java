package dao.impl;

import dao.LogDao;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConsoleDaoImpl implements LogDao {

    private static Logger logger = Logger.getLogger(String.valueOf(LogConsoleDaoImpl.class));

    public int save(String logText, String transaction) {

        ConsoleHandler ch = null;

        try {

            ch = new ConsoleHandler();

            logger.addHandler(ch);
            logger.log(Level.INFO, logText);
            ch.close();
            return 1;

        } catch (Exception ex) {
            logger.info(transaction + ex.getMessage());
        } finally {
            ch = null;
        }

        return 0;

    }

    public void createTable() {

    }

}
