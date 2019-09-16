import entity.JobLogger;
import service.LogService;

import java.io.File;
import java.io.IOException;

public class Test01 {


    public static void main(String[] args) {

        LogService logService = new LogService();
        JobLogger jobLogger = new JobLogger(true, false, true,
                true, true, true, " INSERT INTO customers(id,name)VALUES(1,'Empresa')", "123456");
        logService.LogMessage(jobLogger);

    }

}
