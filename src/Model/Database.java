package Model;

import java.security.PublicKey;
import java.sql.*;

public class Database {

    private String user = "root";
    private String password = "Prince@[2004]*";
    private String url = "jdbc:mysql://localhost/carrental";
    private Connection con;
    private Statement statement;

    public Database() {
        try {
            con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }


}
