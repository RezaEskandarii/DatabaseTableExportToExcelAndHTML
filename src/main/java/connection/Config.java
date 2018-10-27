package connection;

public class Config {
    public static final     String DB_NAME            = "";     //your database name
    public static final     int    DB_PORT            = 3306;   //add your database port number
    public static final     String SERVER_AADR        = "127.0.0.1";     //your_db_server_address
    public static final     String DB_USERNAME        = "root";  //add your database username
    public static final     String DB_PASSWORD        =  null;   // add your database password
    public static final     String DB_DRIVER          = "com.mysql.cj.jdbc.Driver"; //default driver is mysql-connector driver
    private static final    String CONNECTION_OPTIONS = "?useUnicode=yes&characterEncoding=UTF-8";
    public static final     String DB_URL             = "jdbc:mysql://" + SERVER_AADR + ":" + DB_PORT + "/" + DB_NAME + CONNECTION_OPTIONS;
}
