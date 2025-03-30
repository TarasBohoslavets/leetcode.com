package Problem_List.Q403_Frog_Jump;

import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false; // Перший стрибок має бути 1

        // Використовуємо Map для зберігання можливих довжин стрибків
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(1); // Початковий стрибок = 1

        for (int stone : stones) {
            for (int k : dp.get(stone)) {
                int nextPos = stone + k;
                if (dp.containsKey(nextPos)) { // Переконуємося, що такий камінь існує
                    if (k - 1 > 0) dp.get(nextPos).add(k - 1);
                    dp.get(nextPos).add(k);
                    dp.get(nextPos).add(k + 1);
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty(); // Перевіряємо, чи жаба може дістатися останнього каменя
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(new int[]{0,1,3,5,6,8,12,17})); // true
        System.out.println(solution.canCross(new int[]{0,1,2,3,4,8,9,11})); // false
        System.out.println(solution.canCross(new int[]{0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30})); // false
    }
}
