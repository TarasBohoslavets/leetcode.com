package Problem_List.Q344_Reverse_String;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString ( s1 );
        System.out.println ( java.util.Arrays.toString ( s1 ) ); // Output: [o, l, l, e, h]

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString ( s2 );
        System.out.println ( java.util.Arrays.toString ( s2 ) ); // Output: [h, a, n, n, a, H]
    }

    public void reverseString ( char[] s ) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            // Swap characters at left and right
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            // Move pointers
            left++;
            right--;
        }
    }
}

