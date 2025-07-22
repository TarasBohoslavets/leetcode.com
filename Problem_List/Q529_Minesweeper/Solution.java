package Problem_List.Q529_Minesweeper;

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            reveal(board, row, col);
        }

        return board;
    }

    private void reveal(char[][] board, int r, int c) {
        if (!isValid(board, r, c) || board[r][c] != 'E') return;

        int mines = countAdjacentMines(board, r, c);

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
        } else {
            board[r][c] = 'B';
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr != 0 || dc != 0) {
                        reveal(board, r + dr, c + dc);
                    }
                }
            }
        }
    }

    private int countAdjacentMines(char[][] board, int r, int c) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = r + dr, nc = c + dc;
                if (isValid(board, nr, nc) && board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
