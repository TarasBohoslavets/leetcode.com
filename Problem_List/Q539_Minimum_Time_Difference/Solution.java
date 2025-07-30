package Problem_List.Q539_Minimum_Time_Difference;

import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int min = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            minutes.add(min);
        }

        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // враховуємо різницю між останнім і першим через північ
        int first = minutes.get(0);
        int last = minutes.get(minutes.size() - 1);
        minDiff = Math.min(minDiff, 1440 - last + first);

        return minDiff;
    }
}
