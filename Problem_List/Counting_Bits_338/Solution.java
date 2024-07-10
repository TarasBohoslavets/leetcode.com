package Problem_List.Counting_Bits_338;

import java.util.Arrays;

class Solution {
    public static void main ( String[] args ) {
        Solution sol = new Solution ( );
        int n1 = 2;
        int n2 = 5;

        System.out.println ( Arrays.toString ( sol.countBits ( n1 ) ) ); // Output: [0, 1, 1]
        System.out.println ( Arrays.toString ( sol.countBits ( n2 ) ) ); // Output: [0, 1, 1, 2, 1, 2]
    }

    //    public int[] countBits ( int n ) {
//        int[] res = new int[n + 1];
//        int i = 0;
//        while (i <= n) {
//            int x = i;
//            int ones = 0;
//            while (x > 0) {
//                ones += (1 & x);
//                x = x >> 1;
//            }
//            res[i] = ones;
//            i++;
//        }
//        return res;
//    }
    public int[] countBits ( int n ) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
