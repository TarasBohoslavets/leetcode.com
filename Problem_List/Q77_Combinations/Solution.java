package Problem_List.Q77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Якщо поточний список досяг розміру k, додаємо його до результату
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // Перебираємо числа від start до n
        for (int i = start; i <= n; i++) {
            tempList.add(i); // Додаємо поточний елемент до списку
            backtrack(result, tempList, i + 1, n, k); // Рекурсивно додаємо наступні елементи
            tempList.removeLast(); // Відкатуємося до попереднього стану
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4, 2)); // Виведе: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
