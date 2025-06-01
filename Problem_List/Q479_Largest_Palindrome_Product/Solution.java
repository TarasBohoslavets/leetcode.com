package Problem_List.Q479_Largest_Palindrome_Product;

class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int upper = (int)Math.pow(10, n) - 1;
        for (int left = upper; left >= 1; left--) {
            long p = createPalindrome(left);
            for (long i = upper; i * i >= p; i--) {
                if (p % i == 0) {
                    long other = p / i;
                    if (other >= Math.pow(10, n - 1) && other <= upper) {
                        return (int)(p % 1337);
                    }
                }
            }
        }
        return -1;
    }

    // Створюємо паліндром: наприклад, з 123 -> 123321
    private long createPalindrome(int half) {
        String s = Integer.toString(half);
        StringBuilder sb = new StringBuilder(s).reverse();
        return Long.parseLong(s + sb.toString());
    }
}
