package Problem_List.Q413_Arithmetic_Slices;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int curr = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                count += curr;
            } else {
                curr = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(sol.numberOfArithmeticSlices(new int[]{1}));       // 0
        System.out.println(sol.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9})); // 6
    }
}
