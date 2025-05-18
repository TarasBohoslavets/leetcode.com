package Problem_List.Q461_Hamming_Distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y; // XOR виділяє відмінні біти
        int count = 0;

        // Підрахунок кількості одиниць у результаті XOR
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(1, 4)); // 2
        System.out.println(sol.hammingDistance(3, 1)); // 1
        System.out.println(sol.hammingDistance(0, 0)); // 0
        System.out.println(sol.hammingDistance(255, 0)); // 8
    }
}

