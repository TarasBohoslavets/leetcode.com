package Problem_List.Q178_Rank_Scores;

/*
# Write your MySQL query statement below
SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM
    Scores
ORDER BY
    score DESC;
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RankScores {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        String query = """
                SELECT 
                    score, 
                    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
                FROM 
                    Scores
                ORDER BY 
                    score DESC;
                """;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.printf("%-10s %-10s%n", "Score", "Rank");
            while (resultSet.next()) {
                double score = resultSet.getDouble("score");
                int rank = resultSet.getInt("rank");
                System.out.printf("%-10.2f %-10d%n", score, rank);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
