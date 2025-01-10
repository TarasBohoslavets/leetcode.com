package Problem_List.Q260_Single_Number_III;

class Solution {
    public int[] singleNumber(int[] nums) {
        // 1. Знайти XOR усіх чисел
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 2. Знайти будь-який біт, що відрізняється між двома числами
        int diffBit = xor & (-xor); // Ізоляція наймолодшого значущого біта

        // 3. Розділити числа на дві групи
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                x ^= num; // Числа з бітом 0
            } else {
                y ^= num; // Числа з бітом 1
            }
        }

        return new int[]{x, y};
    }
}