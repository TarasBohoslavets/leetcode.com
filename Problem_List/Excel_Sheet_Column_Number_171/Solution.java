package Problem_List.Excel_Sheet_Column_Number_171;

class Solution {
    public static int titleToNumber ( String columnTitle ) {
        int result = 0;
        int length = columnTitle.length ( );
        for (int i = 0; i < length; i++) {
            int charValue = columnTitle.charAt ( i ) - 'A' + 1;
            result = result * 26 + charValue;
        }
        return result;
    }

    public static void main ( String[] args ) {
        System.out.println ( titleToNumber ( "A" ) );   // Output: 1
        System.out.println ( titleToNumber ( "AB" ) );  // Output: 28
        System.out.println ( titleToNumber ( "ZY" ) );  // Output: 701
    }
}