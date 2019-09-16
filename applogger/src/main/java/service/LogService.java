package service;

import dao.LogDao;
import dao.impl.LogConsoleDaoImpl;
import dao.impl.LogDbDaoImpl;
import dao.impl.LogFileDaoImpl;
import entity.JobLogger;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class LogService {

    private static Logger logger = Logger.getLogger(String.valueOf(LogService.class));

    public int LogMessage(JobLogger jobLogger) {

        LogDao logDao = null;

        int resultOperation = 0;
        String transaction = "[transId:" + jobLogger.getTransactionId() + "]:";

        StringBuilder sbMessageLog = null;

        if (jobLogger.getMessageText() != null && jobLogger.getMessageText().trim().length() > 0) {
            if (jobLogger.isLogToConsole() || jobLogger.isLogToFile() || jobLogger.isLogToDatabase()) {

                sbMessageLog = new StringBuilder(transaction);

                if (jobLogger.isLogError()) {
                    sbMessageLog.append(" error ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(" ").append(jobLogger.getMessageText());
                }

                if (jobLogger.isLogMessage()) {
                    sbMessageLog.append(" message ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(" ").append(jobLogger.getMessageText());
                }

                if (jobLogger.isLogWarning()) {
                    sbMessageLog.append(" warning ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).append(" ").append(jobLogger.getMessageText());
                }

                if (jobLogger.isLogToDatabase()) {
                    logDao = new LogDbDaoImpl();
                    resultOperation = logDao.save(sbMessageLog.toString(), transaction);
                }

                if (jobLogger.isLogToFile()) {
                    logDao = new LogFileDaoImpl();
                    resultOperation = logDao.save(sbMessageLog.toString(), transaction);
                }

                if (jobLogger.isLogToConsole()) {
                    logDao = new LogConsoleDaoImpl();
                    resultOperation = logDao.save(sbMessageLog.toString(), transaction);
                }

                return resultOperation;

            } else {
                logger.info(transaction + "Error or Warning or Message must be specified");
            }
        } else {
            logger.info(transaction + "]Invalid configuration");
        }

        return 0;
    }

}
