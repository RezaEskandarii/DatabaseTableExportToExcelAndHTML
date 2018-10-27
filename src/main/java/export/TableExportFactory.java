package export;

public class TableExportFactory {
    public static TableExportToHTML CreateNewHTMLExport() {
        return new TableExportToHTML();
    }

    public static TableExportToExcel CreateNewExcelExport() {
        return new TableExportToExcel();
    }
}
