package Problem_List.Q477_Total_Hamming_Distance;

public class Solution {
    public int totalHammingDistance(int[] nums) {

        /*
        int total = 0;
        int n = nums.length;

        for(int i = 0; i < 31; i++){
            int countOnes = 0;
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    countOnes++;
                }
            }

            int countZeros = n - countOnes;
            total += countOnes * countZeros;
        }

        return total;
    }
         */

        int total = 0;
        int n = nums.length;

        // Перевіряємо кожну з 32 бітових позицій
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;

            for (int num : nums) {
                // Перевіряємо, чи встановлений i-й біт
                if ((num >> i & 1) == 1) {
                    countOnes++;
                }
            }

            int countZeros = n - countOnes;
            total += countOnes * countZeros;
        }

        return total;
    }

    // Тест
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalHammingDistance(new int[]{4, 14, 2})); // 6
        System.out.println(sol.totalHammingDistance(new int[]{4, 14, 4})); // 4
    }
}

