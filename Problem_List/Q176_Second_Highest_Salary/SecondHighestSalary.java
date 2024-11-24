package Problem_List.Q176_Second_Highest_Salary;

import java.sql.*;

public class SecondHighestSalary {
    public static void main(String[] args) {
        // Параметри підключення до бази даних
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // SQL-запит для знаходження другої найвищої зарплати
        String query = "SELECT " +
                "(SELECT DISTINCT salary " +
                " FROM Employee " +
                " ORDER BY salary DESC " +
                " LIMIT 1 OFFSET 1) AS SecondHighestSalary";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                Integer secondHighestSalary = rs.getInt("SecondHighestSalary");
                if (rs.wasNull()) {
                    System.out.println("Second highest salary: null");
                } else {
                    System.out.println("Second highest salary: " + secondHighestSalary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

