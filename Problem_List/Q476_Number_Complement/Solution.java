package Problem_List.Q476_Number_Complement;

public class Solution {
    public int findComplement(int num) {
        /*
          // Копія числа для визначення довжини
        int mask = 0;
        int temp = num;

        while (temp > 0) {
            mask = (mask << 1) | 1;  // Додаємо одиницю справа
            temp >>= 1;             // Зсуваємо число вправо
        }

        return num ^ mask; // XOR з маскою — інверсія бітів
    }
        */


        // 1. Отримати бінарне представлення числа
        String binary = Integer.toBinaryString(num);

        // 2. Побудувати інверсований бінарний рядок
        StringBuilder complement = new StringBuilder();
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                complement.append('0');
            } else {
                complement.append('1');
            }
        }

        // 3. Перетворити інверсований бінарний рядок у десяткове число
        return Integer.parseInt(complement.toString(), 2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findComplement(5));  // Output: 2
        System.out.println(sol.findComplement(1));  // Output: 0
        System.out.println(sol.findComplement(10)); // Output: 5
    }
}

