package entity;

public class JobLogger {

    private boolean logToFile;
    private boolean logToConsole;
    private boolean logToDatabase;
    private boolean logMessage;
    private boolean logWarning;
    private boolean logError;
    private String messageText;
    private String transactionId;

    public JobLogger(boolean logToFile, boolean logToConsole, boolean logToDatabase, boolean logMessage, boolean logWarning, boolean logError
            , String messageText, String transactionId) {
        this.logToFile = logToFile;
        this.logToConsole = logToConsole;
        this.logMessage = logMessage;
        this.logWarning = logWarning;
        this.logError = logError;
        this.logToDatabase = logToDatabase;
        this.messageText = messageText;
        this.transactionId = transactionId;
    }

    public boolean isLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public void setLogToConsole(boolean logToConsole) {
        this.logToConsole = logToConsole;
    }

    public boolean isLogMessage() {
        return logMessage;
    }

    public void setLogMessage(boolean logMessage) {
        this.logMessage = logMessage;
    }

    public boolean isLogWarning() {
        return logWarning;
    }

    public void setLogWarning(boolean logWarning) {
        this.logWarning = logWarning;
    }

    public boolean isLogError() {
        return logError;
    }

    public void setLogError(boolean logError) {
        this.logError = logError;
    }

    public boolean isLogToDatabase() {
        return logToDatabase;
    }

    public void setLogToDatabase(boolean logToDatabase) {
        this.logToDatabase = logToDatabase;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
