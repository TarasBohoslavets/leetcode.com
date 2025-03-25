package Problem_List.Q398_Random_Pick_Index;

import java.util.*;

public class Solution {
    private Map<Integer, List<Integer>> indexMap;
    private Random random;

    public Solution(int[] nums) {
        indexMap = new HashMap<>();
        random = new Random();

        // Заповнюємо мапу, де ключ - число, а значення - список індексів цього числа
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = indexMap.get(target);
        // Випадково вибираємо один з індексів
        return indices.get(random.nextInt(indices.size()));
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3)); // Повинен повернути 2, 3 або 4
        System.out.println(solution.pick(1)); // Повинен повернути 0
        System.out.println(solution.pick(3)); // Повинен повернути 2, 3 або 4
    }
}
