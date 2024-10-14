package Problem_List.Q119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int rowIndex1 = 3;
        List<Integer> result1 = solution.getRow ( rowIndex1 );
        System.out.println ( result1 ); // Output: [1, 3, 3, 1]

        // Example 2
        int rowIndex2 = 0;
        List<Integer> result2 = solution.getRow ( rowIndex2 );
        System.out.println ( result2 ); // Output: [1]

        // Example 3
        int rowIndex3 = 1;
        List<Integer> result3 = solution.getRow ( rowIndex3 );
        System.out.println ( result3 ); // Output: [1, 1]
    }

    public List<Integer> getRow ( int rowIndex ) {
        List<Integer> row = new ArrayList<> ( );
        row.add ( 1 ); // The first element is always 1

        // Compute the rest of the elements
        for (int i = 1; i <= rowIndex; i++) {
            long prev = row.get ( i - 1 );
            long current = prev * (rowIndex - i + 1) / i;
            row.add ( (int) current );
        }

        return row;
    }
}
