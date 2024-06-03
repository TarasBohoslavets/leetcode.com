package Problem_List.Excel_Sheet_Column_Title_168;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        int test1 = 1;
        String result1 = solution.convertToTitle ( test1 );
        System.out.println ( "Input: " + test1 + " -> Output: " + result1 + " (Expected: A)" );

        int test2 = 28;
        String result2 = solution.convertToTitle ( test2 );
        System.out.println ( "Input: " + test2 + " -> Output: " + result2 + " (Expected: AB)" );

        int test3 = 701;
        String result3 = solution.convertToTitle ( test3 );
        System.out.println ( "Input: " + test3 + " -> Output: " + result3 + " (Expected: ZY)" );

        int test4 = 52;
        String result4 = solution.convertToTitle ( test4 );
        System.out.println ( "Input: " + test4 + " -> Output: " + result4 + " (Expected: AZ)" );

        int test5 = 703;
        String result5 = solution.convertToTitle ( test5 );
        System.out.println ( "Input: " + test5 + " -> Output: " + result5 + " (Expected: AAA)" );

        int test6 = 26;
        String result6 = solution.convertToTitle ( test6 );
        System.out.println ( "Input: " + test6 + " -> Output: " + result6 + " (Expected: Z)" );
    }

    public String convertToTitle ( int columnNumber ) {
        StringBuilder sb = new StringBuilder ( );

        while (columnNumber > 0) {
            columnNumber--;  // Перехід до 0-індексованої системи
            int remainder = columnNumber % 26;
            char currentChar = (char) (remainder + 'A');
            sb.insert ( 0, currentChar );  // Додаємо символ на початок рядка
            columnNumber /= 26;  // Переходимо до наступної "цифри"
        }

        return sb.toString ( );
    }
}
