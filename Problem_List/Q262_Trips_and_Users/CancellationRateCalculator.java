package Problem_List.Q262_Trips_and_Users;

import java.sql.*;
import java.util.*;

public class CancellationRateCalculator {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        String query = """
                SELECT 
                    t.request_at AS Day,
                    ROUND(SUM(CASE 
                                 WHEN t.status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1 
                                 ELSE 0 
                              END) / COUNT(*), 2) AS `Cancellation Rate`
                FROM 
                    Trips t
                JOIN 
                    Users c ON t.client_id = c.users_id AND c.banned = 'No'
                JOIN 
                    Users d ON t.driver_id = d.users_id AND d.banned = 'No'
                WHERE 
                    t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
                GROUP BY 
                    t.request_at
                ORDER BY 
                    t.request_at;
                """;

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            List<Map<String, String>> results = new ArrayList<>();

            while (resultSet.next()) {
                Map<String, String> row = new HashMap<>();
                row.put("Day", resultSet.getString("Day"));
                row.put("Cancellation Rate", resultSet.getString("Cancellation Rate"));
                results.add(row);
            }

            System.out.println("Results:");
            for (Map<String, String> result : results) {
                System.out.println("Day: " + result.get("Day") + ", Cancellation Rate: " + result.get("Cancellation Rate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

