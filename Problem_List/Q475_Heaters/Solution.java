package Problem_List.Q475_Heaters;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);   // Сортуємо будинки
        Arrays.sort(heaters);  // Сортуємо обігрівачі

        int radius = 0;

        for (int house : houses) {
            // Використовуємо binary search для знаходження найменшої відстані
            int index = Arrays.binarySearch(heaters, house);

            if (index >= 0) {
                // Точне попадання — відстань = 0
                continue;
            } else {
                index = -(index + 1); // найближчий правий
                int dist1 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                int dist2 = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int minDist = Math.min(dist1, dist2);
                radius = Math.max(radius, minDist);
            }
        }

        return radius;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findRadius(new int[]{1, 2, 3}, new int[]{2}));           // Output: 1
        System.out.println(sol.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));      // Output: 1
        System.out.println(sol.findRadius(new int[]{1, 5}, new int[]{2}));              // Output: 3
    }
}

