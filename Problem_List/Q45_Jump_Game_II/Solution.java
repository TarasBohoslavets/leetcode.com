package Problem_List.Q45_Jump_Game_II;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Знаходимо найдальшу позицію, яку можемо досягти з поточної
            farthest = Math.max(farthest, i + nums[i]);

            // Якщо досягли кінця поточного стрибка, збільшуємо кількість стрибків
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}