package Problem_List.Q447_Number_of_Boomerangs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int[] p : points) {
            Map<Integer, Integer> distanceCount = new HashMap<>();

            for (int[] q : points) {
                int dx = p[0] - q[0];
                int dy = p[1] - q[1];
                int dist = dx * dx + dy * dy; // квадрат евклідової відстані
                distanceCount.put(dist, distanceCount.getOrDefault(dist, 0) + 1);
            }

            for (int count : distanceCount.values()) {
                res += count * (count - 1); // бумеранги: варіанти розміщення j та k
            }
        }

        return res;
    }
}
