package Problem_List.Q289_Game_of_Life;

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Визначаємо напрямки для сусідів
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},         {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // Оновлюємо стани
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Підрахунок живих сусідів
                for (int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && Math.abs(board[ni][nj]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Застосування правил гри
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Жива → Мертва
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Мертва → Жива
                }
            }
        }

        // Оновлюємо остаточні стани
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1; // Тимчасовий стан 2 → Жива
                } else if (board[i][j] == -1) {
                    board[i][j] = 0; // Тимчасовий стан -1 → Мертва
                }
            }
        }
    }
}

