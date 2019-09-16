package conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDB {

    private static String filePath = null;
    private static Logger logger = Logger.getLogger(String.valueOf(FileDB.class));

    private FileDB() {

        Properties properties = null;
        InputStream inputStreamConfig = null;
        File logFolder = null;
        File logFile = null;

        try {

            inputStreamConfig = new FileInputStream("database.properties");
            properties = new Properties();

            properties.load(inputStreamConfig);

            logFolder = new File(properties.get("LOGFOLDER").toString());
            logFile = new File(properties.get("LOGFOLDER").toString() + File.separator + properties.getProperty("LOGFILE").toString());

            if (!logFile.exists()) {
                logFolder.mkdirs();
                logFile.createNewFile();
            }

            inputStreamConfig.close();
            filePath = logFile.getAbsolutePath();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        } finally {
            logFolder = null;
            logFile = null;
            inputStreamConfig = null;
        }
    }

    public static String getFileStore() {

        if (filePath == null || filePath.trim().length() > 0) {
            new FileDB();
        }
        return filePath;
    }

}
