package Problem_List.Q438_Find_All_Anagrams_in_a_String;
/*
Ідея:
Ми шукаємо всі підрядки довжини p.length() у s, які є анаграмами p.
Анаграми — це слова, які мають однакову кількість кожної літери.
Тому:
Замість того, щоб щоразу сортувати підрядок, ми можемо:
Порахувати кількість кожної букви у p.
Використовувати "вікно" розміру p.length() у s, яке рухається на 1 праворуч.
Для кожного вікна — перевіряти частоти літер.

✅ Алгоритм:
Порахувати кількість кожної літери в p.
Використовувати масив (або мапу) для кількостей у поточному вікні s.
Рухати вікно розміром p.length().
Якщо кількості співпадають — зберегти індекс.
*/
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Заповнюємо частоти для p і для першого вікна у s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Рухаємось по рядку s
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; // додаємо новий символ
            sCount[s.charAt(i - p.length()) - 'a']--; // прибираємо символ, що вийшов з вікна

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(sol.findAnagrams("abab", "ab"));         // [0,1,2]
    }
}

