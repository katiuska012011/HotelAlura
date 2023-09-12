package main.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/hotelAlura?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "Sigef0101@");

        System.out.println("Cerrando la conexión");
        con.close();
    }
}
