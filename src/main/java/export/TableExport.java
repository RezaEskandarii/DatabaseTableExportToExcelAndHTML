package export;

import connection.DatabaseConnection;

import java.sql.Connection;

public abstract class TableExport {

    protected final static String TAB = ",";
    protected final static String NEXT_LINE = "\n";

    private DatabaseConnection databaseConnection = DatabaseConnection.getNewInstance();

    protected Connection connection = databaseConnection.getConnection();

    protected String fileName;

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
