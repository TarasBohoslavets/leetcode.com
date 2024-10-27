package Problem_List.Q130_Surrounded_Regions;

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Проходимо по першому і останньому рядках
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }

        // Проходимо по першому і останньому стовпчиках
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }

        // Заміна оточених 'O' на 'X' і 'T' назад на 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    // DFS для відмітки неоточених 'O'
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = 'T';
        dfs(board, i + 1, j); // вниз
        dfs(board, i - 1, j); // вверх
        dfs(board, i, j + 1); // вправо
        dfs(board, i, j - 1); // вліво
    }
}
