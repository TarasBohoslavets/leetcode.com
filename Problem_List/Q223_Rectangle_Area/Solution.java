package Problem_List.Q223_Rectangle_Area;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Площа першого прямокутника
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        // Площа другого прямокутника
        int area2 = (bx2 - bx1) * (by2 - by1);

        // Перекриття по ширині
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        // Перекриття по висоті
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        // Площа перекриття
        int overlapArea = overlapWidth * overlapHeight;

        // Загальна площа
        return area1 + area2 - overlapArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4;
        int bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        int result1 = solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        System.out.println("Example 1 Output: " + result1); // Вивід: 45

        // Приклад 2
        int ax1_2 = -2, ay1_2 = -2, ax2_2 = 2, ay2_2 = 2;
        int bx1_2 = -2, by1_2 = -2, bx2_2 = 2, by2_2 = 2;
        int result2 = solution.computeArea(ax1_2, ay1_2, ax2_2, ay2_2, bx1_2, by1_2, bx2_2, by2_2);
        System.out.println("Example 2 Output: " + result2); // Вивід: 16
    }
}
