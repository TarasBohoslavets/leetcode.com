package Problem_List.Q184_Department_Highest_Salary;

import java.sql.*;

public class DepartmentHighestSalary {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        String query = """
            SELECT 
                d.name AS Department,
                e.name AS Employee,
                e.salary AS Salary
            FROM 
                Employee e
            JOIN 
                Department d
            ON 
                e.departmentId = d.id
            WHERE 
                e.salary = (
                    SELECT MAX(salary)
                    FROM Employee
                    WHERE departmentId = e.departmentId
                );
        """;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String department = resultSet.getString("Department");
                String employee = resultSet.getString("Employee");
                int salary = resultSet.getInt("Salary");

                System.out.printf("Department: %s, Employee: %s, Salary: %d%n", department, employee, salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

