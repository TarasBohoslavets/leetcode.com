package Problem_List.Q455_Assign_Cookies;

import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // сортуємо масив жадібності дітей
        Arrays.sort(s); // сортуємо масив розмірів печива

        int child = 0;
        int cookie = 0;

        // Поки є діти та печиво
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // якщо печиво задовольняє дитину
                child++; // переходимо до наступної дитини
            }
            cookie++; // переходимо до наступного печива
        }

        return child; // повертаємо кількість задоволених дітей
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Приклад 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Example 1 (Expected: 1): " + sol.findContentChildren(g1, s1));

        // Приклад 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Example 2 (Expected: 2): " + sol.findContentChildren(g2, s2));

        // Додатковий приклад
        int[] g3 = {10, 9, 8};
        int[] s3 = {5, 6, 7};
        System.out.println("Example 3 (Expected: 0): " + sol.findContentChildren(g3, s3));
    }
}


