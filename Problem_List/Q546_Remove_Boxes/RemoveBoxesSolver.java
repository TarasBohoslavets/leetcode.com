package Problem_List.Q546_Remove_Boxes;

import java.util.*;

public class RemoveBoxesSolver {
    private Map<String, Integer> memo;

    public int removeBoxes(int[] boxes) {
        memo = new HashMap<>();
        return dfs(boxes, 0, boxes.length - 1, 0);
    }

    private int dfs(int[] boxes, int l, int r, int k) {
        if (l > r) return 0;

        String key = l + "," + r + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        // Згруповуємо однакові елементи справа
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        // Варіант: видалити останній блок одразу
        int res = dfs(boxes, l, r - 1, 0) + (k + 1) * (k + 1);

        // Варіант: знайти однакові елементи зліва і об'єднати
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                res = Math.max(res,
                        dfs(boxes, l, i, k + 1) + dfs(boxes, i + 1, r - 1, 0));
            }
        }

        memo.put(key, res);
        return res;
    }

    // Для тестування
    public static void main(String[] args) {
        RemoveBoxesSolver solver = new RemoveBoxesSolver();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println("Max points: " + solver.removeBoxes(boxes));
    }
}
