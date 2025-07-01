package Problem_List.Q517_Super_Washing_Machines;

class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) total += m;
        int n = machines.length;

        if (total % n != 0) return -1;

        int target = total / n;
        int maxMoves = 0, balance = 0;

        for (int load : machines) {
            int diff = load - target;
            balance += diff;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(balance), diff));
        }
        return maxMoves;
    }
}
