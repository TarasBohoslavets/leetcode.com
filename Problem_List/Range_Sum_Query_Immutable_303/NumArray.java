package Problem_List.Range_Sum_Query_Immutable_303;

public class NumArray {
    private int[] prefixSums;

    public NumArray ( int[] nums ) {
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public static void main ( String[] args ) {
        // Example Usage
        NumArray numArray = new NumArray ( new int[]{-2, 0, 3, -5, 2, -1} );
        System.out.println ( numArray.sumRange ( 0, 2 ) ); // Output: 1
        System.out.println ( numArray.sumRange ( 2, 5 ) ); // Output: -1
        System.out.println ( numArray.sumRange ( 0, 5 ) ); // Output: -3
    }

    public int sumRange ( int left, int right ) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}
