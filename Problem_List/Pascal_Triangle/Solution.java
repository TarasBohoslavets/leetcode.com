package Problem_List.Pascal_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate ( numRows1 );
        System.out.println ( result1 ); // Output: [[1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1]]

        // Example 2
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate ( numRows2 );
        System.out.println ( result2 ); // Output: [[1]]
    }

    public List<List<Integer>> generate ( int numRows ) {
        List<List<Integer>> triangle = new ArrayList<> ( );

        // Base case
        if ( numRows <= 0 ) {
            return triangle;
        }

        // First row is always [1]
        triangle.add ( new ArrayList<> ( ) );
        triangle.get ( 0 ).add ( 1 );

        // Build the triangle row by row
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<> ( );
            List<Integer> prevRow = triangle.get ( rowNum - 1 );

            // The first element of each row is always 1
            row.add ( 1 );

            // Each element (except the first and last) is the sum of the two elements above it
            for (int j = 1; j < rowNum; j++) {
                row.add ( prevRow.get ( j - 1 ) + prevRow.get ( j ) );
            }

            // The last element of each row is always 1
            row.add ( 1 );

            triangle.add ( row );
        }

        return triangle;
    }
}

