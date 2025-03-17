package Problem_List.Q390_Elimination_Game;

public class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;

        while (n > 1) {
            if (left || n % 2 == 1) {
                head += step;
            }
            step *= 2;
            n /= 2;
            left = !left;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(9)); // Очікуваний вивід: 6
        System.out.println(solution.lastRemaining(1)); // Очікуваний вивід: 1
    }
}

