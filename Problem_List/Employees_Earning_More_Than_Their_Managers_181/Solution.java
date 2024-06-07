package Problem_List.Employees_Earning_More_Than_Their_Managers_181;

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

    // Test method to verify the implementation
    public static void test () {
        // Replace with your actual database URL, username, and password
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        Solution solution = new Solution ( jdbcUrl, username, password );

        // Check the results
        solution.findEmployeesEarningMoreThanTheirManagers ( );

        // Additional verification can be done here, e.g., comparing the results
        // with the expected output programmatically if needed.
    }

    public static void main ( String[] args ) {
        test ( );
    }

    public void findEmployeesEarningMoreThanTheirManagers () {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection ( jdbcUrl, username, password );

            // Create the statement
            statement = connection.createStatement ( );

            // SQL query to find employees who earn more than their managers
            String sql = "SELECT e1.name AS Employee " +
                    "FROM Employee e1 " +
                    "JOIN Employee e2 ON e1.managerId = e2.id " +
                    "WHERE e1.salary > e2.salary";

            // Execute the query
            resultSet = statement.executeQuery ( sql );

            // Process the result set
            System.out.println ( "+----------+" );
            System.out.println ( "| Employee |" );
            System.out.println ( "+----------+" );
            while (resultSet.next ( )) {
                String employeeName = resultSet.getString ( "Employee" );
                System.out.printf ( "| %-8s |\n", employeeName );
            }
            System.out.println ( "+----------+" );

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

