package Problem_List.Q180_Consecutive_Numbers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumbersFinder {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Заміни на свою базу даних
        String user = "your_username"; // Заміни на своє ім'я користувача
        String password = "your_password"; // Заміни на свій пароль

        // SQL-запит для знаходження чисел, які з'являються три або більше разів поспіль
        String sqlQuery = """
//            SELECT DISTINCT log1.num AS ConsecutiveNums
//            FROM Logs log1, Logs log2, Logs log3
//            WHERE log1.id = log2.id - 1
//              AND log2.id = log3.id - 1
//              AND log1.num = log2.num
//              AND log2.num = log3.num;

        SELECT DISTINCT num AS ConsecutiveNums
        FROM (
            SELECT num,
                   LAG(num) OVER (ORDER BY id) AS prev_num,
                   LEAD(num) OVER (ORDER BY id) AS next_num
            FROM Logs
        ) sub
        WHERE num = prev_num AND num = next_num;
        
        """;

        // Список для збереження результатів
        List<String> consecutiveNumbers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Обробка результатів запиту
            while (resultSet.next()) {
                consecutiveNumbers.add(resultSet.getString("ConsecutiveNums"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Виведення результатів
        if (consecutiveNumbers.isEmpty()) {
            System.out.println("No numbers found with at least three consecutive occurrences.");
        } else {
            System.out.println("Numbers with at least three consecutive occurrences:");
            for (String num : consecutiveNumbers) {
                System.out.println(num);
            }
        }
    }
}

