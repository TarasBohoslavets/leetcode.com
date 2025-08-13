package Problem_List.Q554_Brick_Wall;

import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {
            int sum = 0;
            // Не враховуємо останню цеглу — бо лінія не може йти по краю
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                edgeCount.put(sum, edgeCount.getOrDefault(sum, 0) + 1);
                maxEdges = Math.max(maxEdges, edgeCount.get(sum));
            }
        }

        return wall.size() - maxEdges;
    }
}
