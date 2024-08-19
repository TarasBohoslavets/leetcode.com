package Problem_List.Q43_Multiply_Strings;

public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        // Перемноження цифр з кінця обох рядків
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10; // остання цифра
                result[i + j] += sum / 10;    // перенесення на наступну позицію
            }
        }

        // Побудова результату з масиву
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.isEmpty() && num == 0)) { // пропуск початкових нулів
                sb.append(num);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
        //return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("2", "3"));       // Виведе "6"
        System.out.println(sol.multiply("123", "456"));   // Виведе "56088"
    }
}
