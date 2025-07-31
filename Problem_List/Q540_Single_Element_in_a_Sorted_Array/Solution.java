package Problem_List.Q540_Single_Element_in_a_Sorted_Array;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean halvesAreEven = (high - mid) % 2 == 0;

            if (nums[mid] == nums[mid + 1]) {
                if (halvesAreEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (halvesAreEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[low];
    }
}
