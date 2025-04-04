package Problem_List.Q410_Split_Array_Largest_Sum;

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // найбільший елемент
            high += num;              // сума всіх елементів
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int pieces = 1;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                pieces++;
                currentSum = num;
                if (pieces > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.splitArray(new int[]{7,2,5,10,8}, 2)); // 18
        System.out.println(sol.splitArray(new int[]{1,2,3,4,5}, 2));  // 9
    }
}
