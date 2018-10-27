
import export.TableExport;
import export.TableExportFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TableExport tableExport = TableExportFactory.CreateNewExcelExport();
        tableExport.setFileName("users.csv");
        tableExport.setSqlQuery("SELECT id,name,enabled,created_at FROM users");
        tableExport.export();
        //***************************************************//
        TableExport htmlExport = TableExportFactory.CreateNewHTMLExport();
        htmlExport.setFileName("users.html");
        htmlExport.setSqlQuery("SELECT id,name,enabled,created_at FROM users");
        htmlExport.export();
    }
}
