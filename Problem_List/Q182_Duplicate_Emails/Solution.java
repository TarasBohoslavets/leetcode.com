package Problem_List.Q182_Duplicate_Emails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Solution {

    // Database credentials
    private String jdbcUrl;
    private String username;
    private String password;

    // Constructor to initialize database credentials
    public Solution ( String jdbcUrl, String username, String password ) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public static void main ( String[] args ) {
        // Replace with your actual database URL, username, and password
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        Solution solution = new Solution ( jdbcUrl, username, password );
        solution.findDuplicateEmails ( );
    }

    public void findDuplicateEmails () {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection ( jdbcUrl, username, password );

            // Create the statement
            statement = connection.createStatement ( );

            // SQL query to find duplicate emails
            String sql = "SELECT email AS Email " +
                    "FROM Person " +
                    "GROUP BY email " +
                    "HAVING COUNT(email) > 1";

            // Execute the query
            resultSet = statement.executeQuery ( sql );

            // Process the result set
            System.out.println ( "+---------+" );
            System.out.println ( "| Email   |" );
            System.out.println ( "+---------+" );
            while (resultSet.next ( )) {
                String email = resultSet.getString ( "Email" );
                System.out.printf ( "| %-7s |\n", email );
            }
            System.out.println ( "+---------+" );

        } catch (SQLException e) {
            e.printStackTrace ( );
        } finally {
            // Close the resources
            try {
                if ( resultSet != null ) resultSet.close ( );
                if ( statement != null ) statement.close ( );
                if ( connection != null ) connection.close ( );
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }
    }
}
