import entity.JobLogger;
import org.junit.Assert;
import org.junit.Test;
import service.LogService;

public class JobLoggerTest {

    @Test
    public void runMessageConsole() {
        LogService logService = new LogService();
        JobLogger jobLogger = new JobLogger(false, true, false,
                true, false, false, " INSERT INTO customers(id,name)VALUES(1,'Empresa')", "123");

        Assert.assertEquals(logService.LogMessage(jobLogger), 1);

    }

    @Test
    public void runMessageFile() {
        LogService logService = new LogService();
        JobLogger jobLogger = new JobLogger(true, false, false,
                true, false, false, " INSERT INTO customers(id,name)VALUES(1,'Empresa')", "456");

        Assert.assertEquals(logService.LogMessage(jobLogger), 1);

    }

    @Test
    public void runMessageDatabase() {
        LogService logService = new LogService();
        JobLogger jobLogger = new JobLogger(false, false, true,
                true, false, false, " INSERT INTO customers(id,name)VALUES(1,'Empresa')", "789");

        Assert.assertEquals(logService.LogMessage(jobLogger), 1);

    }

    @Test
    public void runMessageAll() {
        LogService logService = new LogService();
        JobLogger jobLogger = new JobLogger(true, true, true,
                true, true, true, " INSERT INTO customers(id,name)VALUES(1,'Empresa')", "012");

        Assert.assertEquals(logService.LogMessage(jobLogger), 1);

    }

}
