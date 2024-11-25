package Problem_List.Q177_Nth_Highest_Salary;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {

    // Method to get the Nth highest salary
    public Integer getNthHighestSalary(int N) {
        String query = "SELECT DISTINCT salary FROM Employee ORDER BY salary DESC";
        List<Integer> salaries = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Add all distinct salaries to the list
            while (resultSet.next()) {
                salaries.add(resultSet.getInt("salary"));
            }

            // Return the Nth highest salary if it exists
            if (N <= salaries.size()) {
                return salaries.get(N - 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if N is greater than the number of distinct salaries
    }

    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();
        int N = 2; // Example: Get the 2nd highest salary
        Integer result = repo.getNthHighestSalary(N);

        if (result != null) {
            System.out.println("The " + N + "th highest salary is: " + result);
        } else {
            System.out.println("No " + N + "th highest salary exists.");
        }
    }
}

