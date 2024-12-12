package Problem_List.Q200_Number_of_Islands;
/*
* Пояснення:
Ініціалізація: Перевіряємо, чи масив grid не є порожнім. Якщо так, повертаємо 0.
Перебір елементів: Ітеруємо через кожну клітинку. Якщо знайдена клітинка зі значенням '1', це означає початок нового острова.
Пошук вглиб (DFS):
Рекурсивно переходимо вгору, вниз, вліво, вправо від поточної клітинки.
Змінюємо '1' на '0', щоб уникнути повторного оброблення тієї ж клітинки.
Підрахунок островів: Збільшуємо лічильник островів при кожному новому виклику DFS.
* */

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Якщо знайшли землю ('1'), збільшуємо кількість островів
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j); // Запускаємо пошук вглиб, щоб "затопити" острів
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Вихід із меж масиву або якщо клітинка вже є водою ('0')
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        // "Затоплюємо" поточну клітинку
        grid[i][j] = '0';

        // Рекурсивно перевіряємо всі чотири напрямки
        dfs(grid, i + 1, j); // Вниз
        dfs(grid, i - 1, j); // Вгору
        dfs(grid, i, j + 1); // Вправо
        dfs(grid, i, j - 1); // Вліво
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid1)); // Виведе: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid2)); // Виведе: 3
    }
}