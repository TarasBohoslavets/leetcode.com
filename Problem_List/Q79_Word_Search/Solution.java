package Problem_List.Q79_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        // Перебираємо кожну клітинку на дошці
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Якщо знайдемо першу букву слова, запускаємо пошук
                if (dfs(board, word, i, j, 0)) {
                    return true; // Якщо знайшли слово - повертаємо true
                }
            }
        }
        return false; // Якщо слово не знайдено, повертаємо false
    }

    // Рекурсивний пошук (глибини)
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Якщо індекс рівний довжині слова, це означає, що ми знайшли всі літери
        if (index == word.length()) {
            return true;
        }

        // Перевірка на вихід за межі дошки або якщо букви не збігаються
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Зберігаємо поточну літеру і позначаємо клітинку як відвідану (тимчасово)
        char temp = board[i][j];
        board[i][j] = '#'; // Позначаємо клітинку, щоб не використовувати її вдруге

        // Рекурсивно перевіряємо всіх сусідів (вгору, вниз, ліворуч, праворуч)
        boolean found = dfs(board, word, i + 1, j, index + 1) || // вниз
                dfs(board, word, i - 1, j, index + 1) || // вгору
                dfs(board, word, i, j + 1, index + 1) || // праворуч
                dfs(board, word, i, j - 1, index + 1);   // ліворуч

        // Повертаємо клітинці початкове значення (відкочуємо зміни)
        board[i][j] = temp;

        return found; // Повертаємо результат пошуку
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board1, "ABCCED")); // Виведе: true

        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board2, "SEE")); // Виведе: true

        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board3, "ABCB")); // Виведе: false
    }
}
