package export;

import connection.DatabaseConnection;

import java.sql.Connection;
/**
* @super class for export classes
*/
public abstract class TableExport {
    
    //Separating data in Excel cells
    protected final static String TAB = ",";
    
    //write data in new line
    protected final static String NEXT_LINE = "\n";

    private DatabaseConnection databaseConnection = DatabaseConnection.getNewInstance();

    protected Connection connection = databaseConnection.getConnection();

    //database exports file name
    protected String fileName;
    
    //query for data export
    protected String sqlQuery;

    public abstract void export();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
