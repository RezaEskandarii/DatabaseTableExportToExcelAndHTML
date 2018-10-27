# DatabaseTableExportToExcelAndHTML
Excel &amp; HTML output from database tables

## With this program, you can easily extract Excel and html database tables

### To get started, download your database driver from maven in pom.xml

Then, in the Config file in the Connection folder, enter the basic settings for connecting to the database, such as password and database username, database name, and more.

for Example : 
 ```java
    public static final     String DB_NAME            = ""; //your database name
    public static final     int    DB_PORT            = 3306;   //add your database port number
    public static final     String SERVER_AADR        = "127.0.0.1";     //your_db_server_address
    public static final     String DB_USERNAME        = "root"; //add your database username
    public static final     String DB_PASSWORD        =  null;   // add your database password
    public static final     String DB_DRIVER          = "com.mysql.cj.jdbc.Driver"; //default driver is mysql-connector driver
    private static final    String CONNECTION_OPTIONS = "?useUnicode=yes&characterEncoding=UTF-8";
    public static final     String DB_URL             = "jdbc:mysql://" + SERVER_AADR + ":" + DB_PORT + "/" + DB_NAME + CONNECTION_OPTIONS;
 ```

After installing the driver and performing the settings, you can get the output .

For example, we want to take Excel and html output from the users table .

```java
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

```
 ## Excel Export
<img src="https://github.com/RezaEskandarii/repository-images/blob/master/excel_export.JPG?raw=true">

## HTML Export
<img src="https://raw.githubusercontent.com/RezaEskandarii/repository-images/master/html_export.JPG">
