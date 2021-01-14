import java.sql.*;

public class DataBase {


    public static final String DB_NAME = "manage.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\database\\" + DB_NAME;
    public static final String TABLE_USERS = "users";

    private Connection conn;
    private String col1;
    private String col2;
    private Statement stm;
    private String user;
    private String password;
    private  ResultSet rs = null;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }


    }

    public void createTable2(String col1, String col2) {
        try {
            stm = conn.createStatement();

            stm.execute("CREATE table " + TABLE_USERS + " (" + col1 + " text, " + col2 + " text )");
            stm.close();
        } catch (Exception e) {
            System.out.println("creating probleme excepton + " + e.getMessage());
            e.printStackTrace();
        }


    }

    public boolean insertUser(String user, String password) {
        try {
            stm = conn.createStatement();


            stm.execute("INSERT INTO " + TABLE_USERS+ " values('" + user +"', '"+  password  + "')" );
            stm.close();
            return true;
        } catch (Exception e) {
            System.out.println("The user name and password were not added " + e.getMessage());
            e.printStackTrace();
            return false;
        }


    }

    public boolean deleteUser(String user) {
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * from " + TABLE_USERS + " where user = '" + user +"'");
             if (rs.next()) {stm.execute("delete from " + TABLE_USERS + " where user = '" + user +"'");
             return true;

            }
             else{
                 System.out.println("No such a user was found");
                 return false;
             }



        } catch (Exception e) {
            System.out.println("The user name and password were not added " + e.getMessage());
            e.printStackTrace();
            return false;
        }


    }
}

