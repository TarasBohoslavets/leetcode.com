package Problem_List.Plus_One;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the least significant digit to the most significant digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            // If the digit becomes 10, set it to 0 and propagate the carry
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // If the digit doesn't become 10, no need to propagate the carry further
                return digits;
            }
        }

        // If there's still a carry after processing all digits, create a new array
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.println("Example 1:");
        printArray(result1); // Output should be [1, 2, 4]

        // Example 2
        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("\nExample 2:");
        printArray(result2); // Output should be [4, 3, 2, 2]

        // Example 3
        int[] digits3 = {9};
        int[] result3 = solution.plusOne(digits3);
        System.out.println("\nExample 3:");
        printArray(result3); // Output should be [1, 0]
    }

    // Helper method to print the array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

