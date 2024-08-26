package Problem_List.Q50_Pow_x_n;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        double x1 = 2.00000;
        int n1 = 10;
        double result1 = solution.myPow(x1, n1);
        System.out.println("Input: x = " + x1 + ", n = " + n1);
        System.out.println("Output: " + result1);

        // Example 2
        double x2 = 2.10000;
        int n2 = 3;
        double result2 = solution.myPow(x2, n2);
        System.out.println("Input: x = " + x2 + ", n = " + n2);
        System.out.println("Output: " + result2);

        // Example 3
        double x3 = 2.00000;
        int n3 = -2;
        double result3 = solution.myPow(x3, n3);
        System.out.println("Input: x = " + x3 + ", n = " + n3);
        System.out.println("Output: " + result3);
    }
}
