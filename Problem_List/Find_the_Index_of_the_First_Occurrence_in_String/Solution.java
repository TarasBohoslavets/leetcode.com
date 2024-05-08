package Problem_List.Find_the_Index_of_the_First_Occurrence_in_String;

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int index1 = solution.strStr(haystack1, needle1);
        System.out.println("Example 1:");
        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + index1); // Output should be 0

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int index2 = solution.strStr(haystack2, needle2);
        System.out.println("\nExample 2:");
        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + index2); // Output should be -1
    }
}

