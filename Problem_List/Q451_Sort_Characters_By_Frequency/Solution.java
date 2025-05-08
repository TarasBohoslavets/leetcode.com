package Problem_List.Q451_Sort_Characters_By_Frequency;

import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        // 1. Підрахунок частоти кожного символу
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // 2. Вставляємо всі символи в купу (max-heap) за спаданням частоти
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        // 3. Побудова результату
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            sb.append(String.valueOf(ch).repeat(freq));
        }

        return sb.toString();
    }
}
