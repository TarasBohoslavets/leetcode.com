package Problem_List.Q419_Battleships_in_a_Board;

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // якщо не 'X' — пропускаємо
                if (board[i][j] != 'X') continue;

                // якщо зверху або зліва вже була частина корабля — пропускаємо
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;

                // новий корабель
                count++;
            }
        }

        return count;
    }
}

