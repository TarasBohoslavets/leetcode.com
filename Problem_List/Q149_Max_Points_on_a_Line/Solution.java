package Problem_List.Q149_Max_Points_on_a_Line;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;

        int maxPointsOnLine = 1; // Мінімум одна точка буде сама по собі на прямій

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int maxPointsForCurrentPoint = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Якщо точки однакові, збільшуємо лічильник дублюючих точок
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                // Знаходимо найбільший спільний дільник (НСД) для скорочення дробу
                int gcd = gcd(dx, dy);

                dx /= gcd;
                dy /= gcd;

                // Зберігаємо нахил як строку "dy/dx" у HashMap
                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                maxPointsForCurrentPoint = Math.max(maxPointsForCurrentPoint, slopeMap.get(slope));
            }

            // Оновлюємо загальний максимум точок на одній прямій
            maxPointsOnLine = Math.max(maxPointsOnLine, maxPointsForCurrentPoint + duplicate + 1);
        }
        return maxPointsOnLine;
    }

    // Функція для обчислення найбільшого спільного дільника
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

