package Problem_List.Q526_Beautiful_Arrangement;

class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1]; // щоб відзначати які числа вже використані
        return backtrack(n, 1, used);
    }

    private int backtrack(int n, int pos, boolean[] used) {
        if (pos > n) return 1;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                count += backtrack(n, pos + 1, used);
                used[i] = false; // backtrack
            }
        }
        return count;
    }
}

