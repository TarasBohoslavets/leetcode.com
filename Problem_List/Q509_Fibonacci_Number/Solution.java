package Problem_List.Q509_Fibonacci_Number;

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return curr;
    }
}

