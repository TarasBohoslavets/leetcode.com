package Problem_List.Q464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int maxChoosable;
    private int target;
    private Map<Integer, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosable = maxChoosableInteger;
        this.target = desiredTotal;
        this.memo = new HashMap<>();

        // Якщо сума всіх чисел менша за ціль — перемогти неможливо
        int maxSum = (maxChoosable * (maxChoosable + 1)) / 2;
        if (maxSum < target) return false;

        // Якщо ціль <= 0 — перший гравець виграє одразу
        if (target <= 0) return true;

        return dfs(0, 0);
    }

    // usedMask — бітова маска вибраних чисел, currentSum — поточна сума
    private boolean dfs(int usedMask, int currentSum) {
        if (memo.containsKey(usedMask)) {
            return memo.get(usedMask);
        }

        for (int i = 0; i < maxChoosable; i++) {
            if ((usedMask & (1 << i)) == 0) { // якщо число i+1 ще не вибране
                int nextSum = currentSum + (i + 1);
                int newMask = usedMask | (1 << i);

                // Якщо поточний гравець одразу виграє або залишає іншого без варіанту
                if (nextSum >= target || !dfs(newMask, nextSum)) {
                    memo.put(usedMask, true);
                    return true;
                }
            }
        }

        memo.put(usedMask, false);
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canIWin(10, 11)); // false
        System.out.println(sol.canIWin(10, 0));  // true
        System.out.println(sol.canIWin(10, 1));  // true
    }
}

