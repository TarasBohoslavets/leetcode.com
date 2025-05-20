package Problem_List.Q463_Island_Perimeter;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    perimeter += 4;

                    // Перевіряємо верхню клітинку
                    if (r > 0 && grid[r - 1][c] == 1) {
                        perimeter -= 2;
                    }

                    // Перевіряємо ліву клітинку
                    if (c > 0 && grid[r][c - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(sol.islandPerimeter(grid1)); // 16

        int[][] grid2 = {{1}};
        System.out.println(sol.islandPerimeter(grid2)); // 4

        int[][] grid3 = {{1, 0}};
        System.out.println(sol.islandPerimeter(grid3)); // 4
    }
}

