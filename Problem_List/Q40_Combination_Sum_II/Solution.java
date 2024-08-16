package Problem_List.Q40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Сортуємо масив для полегшення роботи з дублікатами
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;  // Якщо сума перевищує target, повертаємось
        else if (remain == 0) result.add(new ArrayList<>(tempList));  // Якщо знайдено комбінацію, додаємо її до результату
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;  // Пропускаємо дублікати
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i + 1);  // Використовуємо наступний індекс i + 1
                tempList.remove(tempList.size() - 1);  // Видаляємо останній доданий елемент
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(sol.combinationSum2(candidates, target));
        // Виведе [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }
}

