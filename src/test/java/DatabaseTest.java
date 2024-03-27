import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/First Database";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    private Connection conn;

    @Before
    public void setUp() throws Exception {

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Test
    public void testUserRecord() throws SQLException {

        String sql = "SELECT id, username, password FROM users Where id = 1";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        assertEquals("user1", rs.getString("username"));
        assertEquals("password1", rs.getString("password"));
    }

    @Test
    public void testPaymentRecord1() throws SQLException {

        String sql = "SELECT id, name, surname, amount FROM Payment WHERE id = 1 ";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        assertEquals("Eden", rs.getString("name"));
        assertEquals("Hopkins", rs.getString("surname"));
        assertEquals("1500", rs.getString("amount"));
    }

    @Test
    public void testPaymentRecord2() throws SQLException {

        String sql = "SELECT id, name, surname, amount FROM Payment WHERE id = 2 ";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        assertEquals("Derrick", rs.getString("name"));
        assertEquals("Owen", rs.getString("surname"));
        assertEquals("2000", rs.getString("amount"));
    }

    @Test
    public void testPaymentRecord3() throws SQLException {

        String sql = "SELECT id, name, surname, amount FROM Payment WHERE id = 3 ";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        assertEquals("Collin", rs.getString("name"));
        assertEquals("Flowers", rs.getString("surname"));
        assertEquals("2500", rs.getString("amount"));
    }


    @After
    public void tearDown() throws Exception {

        if (conn != null) {
            conn.close();
        }

    }
}
