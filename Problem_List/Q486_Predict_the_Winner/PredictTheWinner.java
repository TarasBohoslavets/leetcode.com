package Problem_List.Q486_Predict_the_Winner;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        // Визначення довжини масиву
        int n = nums.length;

        // Створення таблиці для динамічного програмування
        int[][] dp = new int[n][n];

        // Заповнення таблиці для діагональних елементів
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Заповнення таблиці для інших елементів
        for (int довжина = 1; довжина < n; довжина++) {
            for (int i = 0; i < n - довжина; i++) {
                int j = i + довжина;
                // Гравець1 може вибрати один з двох кінців масиву
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // Якщо різниця між очками гравця1 і гравця2 не менше 0, то гравець1 може виграти
        return dp[0][n - 1] >= 0;
    }
}
