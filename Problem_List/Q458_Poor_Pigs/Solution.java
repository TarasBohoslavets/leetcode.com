package Problem_List.Q458_Poor_Pigs;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie;
        int pigs = 0;

        while (Math.pow(tests + 1, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Example 1: " + sol.poorPigs(4, 15, 15)); // Output: 2
        System.out.println("Example 2: " + sol.poorPigs(4, 15, 30)); // Output: 2
        System.out.println("More buckets: " + sol.poorPigs(1000, 15, 60)); // Output: 5
    }
}
