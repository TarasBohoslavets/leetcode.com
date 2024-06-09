package Problem_List.Customers_Who_Never_Order_183;
/*
SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.id = o.customerId
WHERE o.customerId IS NULL;
*/

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
        solution.findCustomersWhoNeverOrder ( );
    }

    public void findCustomersWhoNeverOrder () {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection ( jdbcUrl, username, password );

            // Create the statement
            statement = connection.createStatement ( );

            // SQL query to find customers who never order
            String sql = "SELECT c.name AS Customers " +
                    "FROM Customers c " +
                    "LEFT JOIN Orders o ON c.id = o.customerId " +
                    "WHERE o.customerId IS NULL";

            // Execute the query
            resultSet = statement.executeQuery ( sql );

            // Process the result set
            System.out.println ( "+-----------+" );
            System.out.println ( "| Customers |" );
            System.out.println ( "+-----------+" );
            while (resultSet.next ( )) {
                String customerName = resultSet.getString ( "Customers" );
                System.out.printf ( "| %-9s |\n", customerName );
            }
            System.out.println ( "+-----------+" );

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

