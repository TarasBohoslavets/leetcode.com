package Problem_List.Q354_Russian_Doll_Envelopes;

import java.util.*;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // Сортуємо: за шириною ASC, за висотою DESC
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Список для LIS
        List<Integer> lis = new ArrayList<>();

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int idx = binarySearch(lis, height);
            if (idx == lis.size()) {
                lis.add(height);  // Додаємо новий елемент
            } else {
                lis.set(idx, height); // Замінюємо на менше значення
            }
        }

        return lis.size();
    }

    // Бінарний пошук для знаходження місця вставки
    private int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
