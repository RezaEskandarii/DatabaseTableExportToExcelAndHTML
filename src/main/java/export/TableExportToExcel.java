package export;

import java.io.*;

import java.sql.*;

public class TableExportToExcel extends TableExport {


    @Override
    public void export() {

        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer fileWriter = null;
        try {
            fileWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        int columnsCount = 0;
        int count = 0;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlQuery);

            resultSet = statement.executeQuery();
            metaData = resultSet.getMetaData();
            columnsCount = metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 1; i < columnsCount + 1; i++) {
                assert metaData != null;
                assert fileWriter != null;
                fileWriter.append(String.valueOf(metaData.getColumnLabel(i)) + TAB);
                fileWriter.flush();
            }
            assert fileWriter != null;
            fileWriter.append(NEXT_LINE);
            fileWriter.flush();
            assert resultSet != null;
            while (resultSet.next()) {
                for (int i = 1; i <= columnsCount; i++) {
                    count++;
                    assert metaData != null;
                    fileWriter.append(String.valueOf(resultSet.getObject(metaData.getColumnLabel(i))) + TAB);
                    fileWriter.flush();
                    if (count == columnsCount) {
                        fileWriter.append(NEXT_LINE);
                        fileWriter.flush();
                        count = 0;
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
