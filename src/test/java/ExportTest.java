import export.TableExport;
import export.TableExportFactory;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ExportTest {
    @Test
    public void ExcelExportTest() {
        TableExport tableExport = TableExportFactory.CreateNewExcelExport();
        tableExport.setSqlQuery("SELECT id,name,enabled,created_at FROM users;");
        String fileName = "users.csv";
        tableExport.setFileName(fileName);
        tableExport.export();
        File file = new File(fileName);
        assertTrue(file.exists());
    }

    @Test
    public void HTMLExportTest() {
        TableExport htmlExport = TableExportFactory.CreateNewHTMLExport();
        htmlExport.setFileName("users.html");
        htmlExport.setSqlQuery("SELECT id,name,enabled,created_at FROM users");
        htmlExport.export();
        File file = new File("users.html");
        assertTrue(file.exists());
    }
}
