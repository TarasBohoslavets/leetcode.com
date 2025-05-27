package Problem_List.Q473_Matchsticks_to_Square;

import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) return false; // якщо загальна довжина не ділиться на 4

        int targetSide = totalLength / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks); // оптимізація: починаємо з найбільших сірників

        int[] sides = new int[4]; // масив для 4 сторін квадрата

        return dfs(matchsticks, 0, sides, targetSide);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            // всі сторони мають бути рівні target
            return sides[0] == target && sides[1] == target &&
                    sides[2] == target && sides[3] == target;
        }

        int curr = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + curr > target) continue; // не можна додати, перевищить сторону

            sides[i] += curr;
            if (dfs(matchsticks, index + 1, sides, target)) return true;
            sides[i] -= curr; // backtrack

            // якщо поточна сторона пуста, то інші пусті також нічого не дадуть
            if (sides[i] == 0) break;
        }

        return false;
    }

    // Допоміжний метод для сортування у спадаючому порядку
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.makesquare(new int[]{1, 1, 2, 2, 2})); // true
        System.out.println(sol.makesquare(new int[]{3, 3, 3, 3, 4})); // false
    }
}
