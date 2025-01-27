package Problem_List.Q306_Additive_Number;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // Перебір усіх можливих перших двох чисел
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                break; // Якщо число починається з 0 і його довжина > 1, воно недійсне
            }
            for (int j = i + 1; j < n; j++) {
                if (num.charAt(i) == '0' && j - i > 1) {
                    break; // Те саме правило для другого числа
                }
                // Перше і друге числа
                BigInteger num1 = new BigInteger(num.substring(0, i));
                BigInteger num2 = new BigInteger(num.substring(i, j));
                if (isValid(num1, num2, j, num)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Метод для перевірки валідності послідовності
    private boolean isValid(BigInteger num1, BigInteger num2, int start, String num) {
        int n = num.length();
        while (start < n) {
            BigInteger sum = num1.add(num2);
            String sumStr = sum.toString();
            if (!num.startsWith(sumStr, start)) {
                return false;
            }
            start += sumStr.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклади з завдання
        System.out.println(solution.isAdditiveNumber("112358")); // Виведе true
        System.out.println(solution.isAdditiveNumber("199100199")); // Виведе true
        System.out.println(solution.isAdditiveNumber("123")); // Виведе true
        System.out.println(solution.isAdditiveNumber("1023")); // Виведе false
    }
}

