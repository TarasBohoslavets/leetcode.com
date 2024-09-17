package Problem_List.Q76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Підраховуємо кількість кожного символу в t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Лічильник кількості символів у поточному вікні, які вже є
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0, formed = 0, required = tFreq.size();
        int[] result = {-1, 0, 0}; // Довжина, лівий та правий індекси мінімального вікна

        while (right < s.length()) {
            // Додаємо символ з правого вказівника до вікна
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Якщо кількість символів збігається з потрібною кількістю у t
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Тепер можемо спробувати звузити вікно з лівого боку
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Оновлюємо мінімальне вікно
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // Прибираємо символ з лівого вказівника
                windowFreq.put(c, windowFreq.get(c) - 1);
                if (tFreq.containsKey(c) && windowFreq.get(c).intValue() < tFreq.get(c).intValue()) {
                    formed--;
                }

                left++; // Зсуваємо лівий вказівник вправо
            }

            right++; // Розширюємо правий вказівник
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}

//class Solution {
//    public String minWindow(String s, String t) {
//        int[] tElements = new int[123];
//        for(char c: t.toCharArray()){
//            tElements[c]++;
//        }
//
//        int left = 0, right = 0;
//        int find = t.length();
//        char[] arr = s.toCharArray();
//
//        int start = 0;
//        int minLength = Integer.MAX_VALUE;
//
//        while(right < arr.length){
//            if(tElements[arr[right]] > 0) find--;
//            tElements[arr[right++]]--;
//
//            while(find == 0){
//                if(right - left < minLength){
//                    start = left;
//                    minLength = right - left;
//                }
//
//                if(tElements[arr[left]] == 0) find++;
//                tElements[arr[left]]++;
//                left++;
//            }
//        }
//
//        if(minLength == Integer.MAX_VALUE) return "";
//        return s.substring(start, start+minLength);
//    }
//}

