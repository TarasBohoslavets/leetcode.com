package Problem_List.Q42_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];

        // Заповнення масиву left_max
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }

        // Заповнення масиву right_max
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }

        // Обчислення загальної кількості води
        int total_water = 0;
        for (int i = 0; i < n; i++) {
            total_water += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return total_water;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(height1)); // Виведе 6

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(sol.trap(height2)); // Виведе 9
    }
}

