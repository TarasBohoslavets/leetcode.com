package Problem_List.Q275_H_Index_II;
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int ans = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                count++;
                if (citations[i] >= count) {
                    ans = count;
                }
            } else {
                count++;
                if (citations[i] >= count) {
                    ans = count;
                }
            }
        }
        return ans;

    }
}


//public class Solution {
//    public int hIndex(int[] citations) {
//        int n = citations.length;
//        int left = 0, right = n - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int h = n - mid; // Кількість статей із щонайменше citations[mid] цитуваннями
//
//            if (citations[mid] >= h) {
//                right = mid - 1; // Шукаємо більше h лівіше
//            } else {
//                left = mid + 1; // Шукаємо більше h правіше
//            }
//        }
//        return n - left; // Остаточний h-індекс
//    }
//}
