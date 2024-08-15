package Problem_List.Q39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return; // якщо сума перевищує target, повертаємось
        else if (remain == 0) result.add(new ArrayList<>(tempList)); // якщо знайдено комбінацію, додаємо її до результату
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]); // додаємо число до поточного списку
                backtrack(result, tempList, candidates, remain - candidates[i], i); // рекурсивно шукаємо далі
                tempList.remove(tempList.size() - 1); // видаляємо останнє додане число, щоб перевірити інші варіанти
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target)); // Виведе [[2, 2, 3], [7]]
    }
}