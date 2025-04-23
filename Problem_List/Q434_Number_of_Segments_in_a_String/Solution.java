package Problem_List.Q434_Number_of_Segments_in_a_String;

public class Solution {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // якщо поточний символ не пробіл, і або це перший символ,
            // або перед ним пробіл — це початок нового сегменту
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Приклади
        System.out.println(sol.countSegments("Hello, my name is John")); // → 5
        System.out.println(sol.countSegments("Hello"));                   // → 1
        System.out.println(sol.countSegments("    "));                    // → 0
        System.out.println(sol.countSegments("This   is   spaced"));     // → 3
        System.out.println(sol.countSegments(""));                        // → 0
        System.out.println(sol.countSegments(" A single leading space")); // → 4
    }
}

