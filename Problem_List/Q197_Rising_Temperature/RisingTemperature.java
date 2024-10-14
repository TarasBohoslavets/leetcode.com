package Problem_List.Q197_Rising_Temperature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON DATE_SUB(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate
WHERE w1.temperature > w2.temperature;

* */

public class RisingTemperature {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main ( String[] args ) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName ( "com.mysql.cj.jdbc.Driver" );

            // Step 2: Open a connection
            System.out.println ( "Connecting to database..." );
            conn = DriverManager.getConnection ( DB_URL, USER, PASS );

            // Step 3: Execute a query to find rising temperatures
            System.out.println ( "Creating statement..." );
            stmt = conn.createStatement ( );
            String sql = "SELECT w1.id " +
                    "FROM Weather w1 " +
                    "JOIN Weather w2 " +
                    "ON DATE_SUB(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate " +
                    "WHERE w1.temperature > w2.temperature";
            rs = stmt.executeQuery ( sql );

            // Step 4: Extract data from result set
            System.out.println ( "Ids with rising temperature:" );
            while (rs.next ( )) {
                // Retrieve by column name
                int id = rs.getInt ( "id" );
                // Display values
                System.out.print ( "ID: " + id );
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        } finally {
            // Step 5: Clean-up environment
            try {
                if ( rs != null ) rs.close ( );
                if ( stmt != null ) stmt.close ( );
                if ( conn != null ) conn.close ( );
            } catch (Exception e) {
                e.printStackTrace ( );
            }
        }
    }
}
