package Problem_List.Q185_Department_Top_Three_Salaries;

import java.sql.*;
import java.util.*;

public class DepartmentTopThreeSalaries {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        String sqlQuery = """
            SELECT 
                d.name AS Department,
                e.name AS Employee,
                e.salary AS Salary,
                DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rank
            FROM 
                Employee e
            JOIN 
                Department d
            ON 
                e.departmentId = d.id
            """;

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Process the results
            List<Map<String, Object>> resultList = new ArrayList<>();
            while (resultSet.next()) {
                int rank = resultSet.getInt("rank");
                if (rank <= 3) {  // Filter only top 3 ranks
                    Map<String, Object> record = new HashMap<>();
                    record.put("Department", resultSet.getString("Department"));
                    record.put("Employee", resultSet.getString("Employee"));
                    record.put("Salary", resultSet.getInt("Salary"));
                    resultList.add(record);
                }
            }

            // Print the results
            for (Map<String, Object> row : resultList) {
                System.out.println("Department: " + row.get("Department") +
                        ", Employee: " + row.get("Employee") +
                        ", Salary: " + row.get("Salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

