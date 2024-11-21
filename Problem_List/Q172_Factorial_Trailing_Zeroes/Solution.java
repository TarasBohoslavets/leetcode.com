package Problem_List.Q172_Factorial_Trailing_Zeroes;

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5; // Ділимо на 5, щоб знайти кількість чисел, кратних 5
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 3;
        System.out.println("Trailing Zeroes (Example 1): " + solution.trailingZeroes(n1)); // Output: 0

        // Example 2
        int n2 = 5;
        System.out.println("Trailing Zeroes (Example 2): " + solution.trailingZeroes(n2)); // Output: 1

        // Example 3
        int n3 = 0;
        System.out.println("Trailing Zeroes (Example 3): " + solution.trailingZeroes(n3)); // Output: 0
    }
}

