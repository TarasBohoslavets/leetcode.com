package Problem_List.Q391_Perfect_Rectangle;

import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int areaSum = 0;

        Set<String> points = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

            // Оновлення граничних координат
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Додаємо площу поточного прямокутника
            areaSum += (x2 - x1) * (y2 - y1);

            // Керування множиною унікальних кутів
            String[] corners = {x1 + "," + y1, x1 + "," + y2, x2 + "," + y1, x2 + "," + y2};
            for (String point : corners) {
                if (!points.add(point)) {
                    points.remove(point);
                }
            }
        }

        // Площа великого прямокутника
        int expectedArea = (maxX - minX) * (maxY - minY);
        if (areaSum != expectedArea) {
            return false;
        }

        // Очікуємо рівно 4 унікальні кути
        if (points.size() != 4 ||
                !points.contains(minX + "," + minY) ||
                !points.contains(minX + "," + maxY) ||
                !points.contains(maxX + "," + minY) ||
                !points.contains(maxX + "," + maxY)) {
            return false;
        }

        return true;
    }
}
