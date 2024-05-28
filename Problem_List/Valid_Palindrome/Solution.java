package Problem_List.Valid_Palindrome;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Приклад 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println ( solution.isPalindrome ( s1 ) ); // Вивід: true

        // Приклад 2
        String s2 = "race a car";
        System.out.println ( solution.isPalindrome ( s2 ) ); // Вивід: false

        // Приклад 3
        String s3 = " ";
        System.out.println ( solution.isPalindrome ( s3 ) ); // Вивід: true
    }

    public boolean isPalindrome ( String s ) {
        if ( s == null ) {
            return false;
        }

        int left = 0;
        int right = s.length ( ) - 1;

        while (left < right) {
            // Пропустити неалфавітно-цифрові символи зліва
            while (left < right && !Character.isLetterOrDigit ( s.charAt ( left ) )) {
                left++;
            }
            // Пропустити неалфавітно-цифрові символи справа
            while (left < right && !Character.isLetterOrDigit ( s.charAt ( right ) )) {
                right--;
            }

            // Порівняти символи, не враховуючи регістр
            if ( Character.toLowerCase ( s.charAt ( left ) ) != Character.toLowerCase ( s.charAt ( right ) ) ) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
