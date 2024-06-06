package Problem_List.Combine_Two_Tables_175;


//    # Write your MySQL query statement below
//    SELECT
//    p.firstName,
//    p.lastName,
//    a.city,
//    a.state
//            FROM
//    Person p
//    LEFT JOIN
//    Address a
//    ON
//    p.personId = a.personId;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Solution {

    public static void main ( String[] args ) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name"; // replace with your database URL
        String username = "your_username"; // replace with your database username
        String password = "your_password"; // replace with your database password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection ( jdbcUrl, username, password );

            // Create the statement
            statement = connection.createStatement ( );

            // SQL query to combine the two tables
            String sql = "SELECT " +
                    "p.firstName, " +
                    "p.lastName, " +
                    "a.city, " +
                    "a.state " +
                    "FROM " +
                    "Person p " +
                    "LEFT JOIN " +
                    "Address a " +
                    "ON p.personId = a.personId";

            // Execute the query
            resultSet = statement.executeQuery ( sql );

            // Process the result set
            while (resultSet.next ( )) {
                String firstName = resultSet.getString ( "firstName" );
                String lastName = resultSet.getString ( "lastName" );
                String city = resultSet.getString ( "city" );
                String state = resultSet.getString ( "state" );

                System.out.printf ( "FirstName: %s, LastName: %s, City: %s, State: %s%n",
                        firstName, lastName, city, state );
            }

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

