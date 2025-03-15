package Problem_List.Q388_Longest_Absolute_File_Path;

import java.util.*;

public class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Map<Integer, Integer> pathLengths = new HashMap<>(); // Збереження довжини шляхів на кожному рівні
        int maxLength = 0;

        for (String line : lines) {
            int level = line.lastIndexOf("\t") + 1; // Кількість табуляцій визначає рівень вкладеності
            int nameLength = line.length() - level; // Довжина імені без табуляцій

            if (line.contains(".")) { // Якщо це файл
                int totalLength = pathLengths.getOrDefault(level - 1, 0) + nameLength;
                maxLength = Math.max(maxLength, totalLength);
            } else { // Якщо це директорія
                pathLengths.put(level, pathLengths.getOrDefault(level - 1, 0) + nameLength + 1); // +1 для символу '/'
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")); // Очікуваний вивід: 20
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")); // Очікуваний вивід: 32
        System.out.println(solution.lengthLongestPath("a")); // Очікуваний вивід: 0
    }
}
