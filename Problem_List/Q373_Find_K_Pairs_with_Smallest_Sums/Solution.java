package Problem_List.Q373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Мінімальна купа (за сумою пар)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Додаємо перші пари (nums1[i], nums2[0]) у купу
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Витягуємо k найменших пар
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Додаємо наступну пару (той самий nums1[i], але наступний nums2[j+1])
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        // [[1,2], [1,4], [1,6]]

        System.out.println(sol.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        // [[1,1], [1,1]]
    }
}

