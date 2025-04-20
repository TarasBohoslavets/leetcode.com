package Problem_List.Q491_Non_decreasing_Subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void dfs(int index, List<Integer> path, int[] nums, List<List<Integer>> result) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>(); // уникнення дублікатів на кожному рівні

        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue; // непадаюча умова
            }

            if (used.contains(nums[i])) {
                continue; // щоб не обробляти однакові елементи на одному рівні
            }

            used.add(nums[i]);
            path.add(nums[i]);
            dfs(i + 1, path, nums, result); // йдемо далі
            path.remove(path.size() - 1); // backtrack
        }
    }
}

