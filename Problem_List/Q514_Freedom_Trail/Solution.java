package Problem_List.Q514_Freedom_Trail;

import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        Map<Character, List<Integer>> indexMap = new HashMap<>();

        // Зберігаємо всі позиції кожного символу в ring
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(ring.charAt(i), x -> new ArrayList<>()).add(i);
        }

        // Кеш для уникнення повторних обчислень
        int[][] memo = new int[n][key.length()];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(ring, key, 0, 0, indexMap, memo);
    }

    private int dfs(String ring, String key, int ringPos, int keyIndex,
                    Map<Character, List<Integer>> indexMap, int[][] memo) {
        if (keyIndex == key.length()) return 0;
        if (memo[ringPos][keyIndex] != -1) return memo[ringPos][keyIndex];

        char targetChar = key.charAt(keyIndex);
        int n = ring.length();
        int minSteps = Integer.MAX_VALUE;

        for (int pos : indexMap.get(targetChar)) {
            int diff = Math.abs(pos - ringPos);
            int steps = Math.min(diff, n - diff); // Мінімальна кількість обертів
            int total = steps + 1 + dfs(ring, key, pos, keyIndex + 1, indexMap, memo); // +1 за натискання кнопки
            minSteps = Math.min(minSteps, total);
        }

        memo[ringPos][keyIndex] = minSteps;
        return minSteps;
    }
}

