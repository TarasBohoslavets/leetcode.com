package Problem_List.Q93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String s, int index, String currentIP, int section) {
        // Якщо досягли кінця рядка і у нас рівно 4 частини — додаємо результат
        if (index == s.length() && section == 4) {
            result.add(currentIP);
            return;
        }
        // Якщо більше 4 частин або рядок закінчився раніше, ніж 4 частини
        if (section > 4 || index >= s.length()) return;

        // Перевіряємо кожну можливу частину (1, 2, або 3 цифри)
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;  // Вихід за межі рядка

            String part = s.substring(index, index + len);
            if (isValid(part)) {
                backtrack(result, s, index + len, currentIP + (section == 0 ? "" : ".") + part, section + 1);
            }
        }
    }

    private boolean isValid(String part) {
        // Частина повинна бути в межах від 0 до 255, і не може мати ведучих нулів
        if (part.length() > 1 && part.startsWith("0")) return false;  // Ведучі нулі
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String s1 = "25525511135";
        System.out.println("Приклад 1: " + solution.restoreIpAddresses(s1));  // Очікуваний вихід: ["255.255.11.135", "255.255.111.35"]

        // Приклад 2
        String s2 = "0000";
        System.out.println("Приклад 2: " + solution.restoreIpAddresses(s2));  // Очікуваний вихід: ["0.0.0.0"]

        // Приклад 3
        String s3 = "101023";
        System.out.println("Приклад 3: " + solution.restoreIpAddresses(s3));  // Очікуваний вихід: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}
