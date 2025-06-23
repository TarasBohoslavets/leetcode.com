package Problem_List.Q507_Perfect_Number;

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1; // 1 завжди дільник
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                int paired = num / i;
                if (paired != i) sum += paired;
            }
        }

        return sum == num;
    }
}
