package Problem_List.Q6_Zigzag_Conversion;

public class ZigzagConversion {
    public static void main ( String[] args ) {
        ZigzagConversion solution = new ZigzagConversion ( );

        // Приклади для перевірки
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println ( solution.convert ( s1, numRows1 ) ); // Вихід: "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println ( solution.convert ( s2, numRows2 ) ); // Вихід: "PINALSIGYAHRPI"

        String s3 = "A";
        int numRows3 = 1;
        System.out.println ( solution.convert ( s3, numRows3 ) ); // Вихід: "A"
    }

    public String convert ( String s, int numRows ) {
        if ( numRows == 1 ) return s; // Якщо кількість рядків 1, просто повертаємо рядок

        StringBuilder[] rows = new StringBuilder[Math.min ( numRows, s.length ( ) )];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder ( );
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray ( )) {
            rows[curRow].append ( c );
            if ( curRow == 0 || curRow == numRows - 1 ) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder ( );
        for (StringBuilder row : rows) {
            result.append ( row );
        }

        return result.toString ( );
    }
}

