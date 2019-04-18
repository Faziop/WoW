package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author alefa
 */
public class RelDatabase {

    private Connection conn;

    public RelDatabase() {
        this.conn = null;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlite:miniwow.db";
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");

    }

    public void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Connection to SQLite has been closed.");
        }

    }

    public int executeUpdate(String statement) {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;   
        }
    }

    public ResultSet executeQuery(String statement) {
        try {
            Statement stm = conn.createStatement();
            return stm.executeQuery(statement);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }

        return null;
    }
}
