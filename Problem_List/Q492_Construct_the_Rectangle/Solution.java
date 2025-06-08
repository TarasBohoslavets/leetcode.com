package Problem_List.Q492_Construct_the_Rectangle;

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);  // Починаємо з кореня — це мінімізує різницю між L і W

        while (area % w != 0) {
            w--;  // Поки не знайдемо дільник
        }

        return new int[]{area / w, w}; // L = area / w, W = w
    }
}
