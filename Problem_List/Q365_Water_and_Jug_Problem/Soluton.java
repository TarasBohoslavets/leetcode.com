package Problem_List.Q365_Water_and_Jug_Problem;

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;  // Якщо target більший за сумарний об'єм двох глеків, це неможливо
        return target % gcd(x, y) == 0;   // target має бути кратним НСД(x, y)
    }

    private int gcd(int a, int b) { // Метод знаходження НСД (алгоритм Евкліда)
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canMeasureWater(3, 5, 4)); // true
        System.out.println(solution.canMeasureWater(2, 6, 5)); // false
        System.out.println(solution.canMeasureWater(1, 2, 3)); // true
    }
}

