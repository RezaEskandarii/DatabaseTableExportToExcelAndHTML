package export;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableExportToHTML extends TableExport {

    HTMLBuilder htmlBuilder;
    protected static final String TAB = "\t";
    public TableExportToHTML() {
        this.htmlBuilder = new HTMLBuilder();
        htmlBuilder.startHtmlDocument();
        htmlBuilder.openHeadTag();
        htmlBuilder.setJavascriptLinks("https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js");
        htmlBuilder.setJavascriptLinks("https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js");
        htmlBuilder.setStylesLink("https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css");
        htmlBuilder.closeHeadTag();
    }

    @Override
    public void export() {
        htmlBuilder.openBody();
        htmlBuilder.setBody("<div class='container'>");
        htmlBuilder.setBody("<div class='row'>");
        htmlBuilder.setBody("<div class='col-lg-12'>");
        htmlBuilder.setBody("<center><h1>");
        htmlBuilder.setData("HTML Export");
        htmlBuilder.setBody("</h1></center></br>");
        htmlBuilder.setBody("<table class='table table-striped table-dark table-bordered'>");
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
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlQuery);
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            resultSet = statement.executeQuery();
            metaData = resultSet.getMetaData();
            columnsCount = metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        htmlBuilder.setBody("<thead><tr>");
        try {
            for (int i = 1; i <= columnsCount; i++) {
                assert metaData != null;
                htmlBuilder.setBody("<td>"+metaData.getColumnLabel(i)+"</td>");
            }
            htmlBuilder.setBody("</tr></thead>");
            htmlBuilder.setBody("<tbody>");
            while (resultSet.next()) {
                htmlBuilder.setBody("<tr>");
                for (int i = 1; i < columnsCount + 1; i++) {

                    htmlBuilder.setBody("<td>");
                    assert metaData != null;
                    htmlBuilder.setBody(String.valueOf(resultSet.getObject(metaData.getColumnLabel(i))));
                    htmlBuilder.setBody("</td>");

                }
                htmlBuilder.setBody("</tr>");
            }
            htmlBuilder.setBody("</tbody>");
            htmlBuilder.setBody("</table>");
            htmlBuilder.setBody("</div>");
            htmlBuilder.setBody("</div>");
            htmlBuilder.setBody("</div>");
            htmlBuilder.closeBody();
            htmlBuilder.closeHtmlDocument();

            assert fileWriter != null;
            fileWriter.write(htmlBuilder.getDocumentResult());
            fileWriter.flush();
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
