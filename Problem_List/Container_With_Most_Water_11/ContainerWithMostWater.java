package Problem_List.Container_With_Most_Water_11;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area with the current pair of lines
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // Update maxArea if we found a larger area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();

        // Test cases
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(container.maxArea(height1)); // Output: 49

        int[] height2 = {1, 1};
        System.out.println(container.maxArea(height2)); // Output: 1
    }
}

