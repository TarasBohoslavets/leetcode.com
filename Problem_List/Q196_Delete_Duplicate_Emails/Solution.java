package Problem_List.Q196_Delete_Duplicate_Emails;
/*
DELETE p1 FROM Person p1
INNER JOIN Person p2
ON p1.email = p2.email AND p1.id > p2.id;

* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Solution {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main ( String[] args ) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName ( "com.mysql.cj.jdbc.Driver" );

            // Step 2: Open a connection
            System.out.println ( "Connecting to database..." );
            conn = DriverManager.getConnection ( DB_URL, USER, PASS );

            // Step 3: Execute a query to delete duplicate emails
            String sql = "DELETE p1 FROM Person p1 INNER JOIN Person p2 ON p1.email = p2.email AND p1.id > p2.id";
            pstmt = conn.prepareStatement ( sql );

            int affectedRows = pstmt.executeUpdate ( );
            System.out.println ( "Deleted " + affectedRows + " duplicate email records." );

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace ( );
        } finally {
            // Step 4: Clean-up environment
            try {
                if ( pstmt != null ) pstmt.close ( );
                if ( conn != null ) conn.close ( );
            } catch (SQLException se) {
                se.printStackTrace ( );
            }
        }
    }
}
