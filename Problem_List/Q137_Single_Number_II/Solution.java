package Problem_List.Q137_Single_Number_II;

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // Перебір кожного біта (32 біти для int)
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            // Підрахунок кількості встановлених бітів на позиції i
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    bitSum++;
                }
            }
            // Якщо кількість встановлених бітів не кратна 3, встановіть цей біт у результаті
            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
