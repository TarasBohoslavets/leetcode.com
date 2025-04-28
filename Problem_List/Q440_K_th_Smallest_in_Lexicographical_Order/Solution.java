package Problem_List.Q440_K_th_Smallest_in_Lexicographical_Order;

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1; // бо ми вже стоїмо на 1

        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1; // переходимо до сусіднього числа
                k -= steps;
            } else {
                curr *= 10; // рухаємося вниз
                k -= 1;
            }
        }

        return curr;
    }

    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
