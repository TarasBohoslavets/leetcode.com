package Problem_List.Q349_Intersection_of_Two_Arrays;

import java.util.HashSet;

//class Solution {
//    public int[] intersection ( int[] nums1, int[] nums2 ) {
//        HashSet<Integer> hash = new HashSet<> ( );
//        HashSet<Integer> hashToArr = new HashSet<> ( );
//        for (int num : nums1) {
//            hash.add ( num );
//        }
//        for (int number : nums2) {
//            if ( hash.contains ( number ) ) {
//                hashToArr.add ( number );
//            }
//        }
//        int[] array = new int[hashToArr.size ( )];
//        int i = 0;
//        for (Integer num2 : hashToArr) {
//            array[i] = num2;
//            i++;
//        }
//        return array;
//    }
//}

import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Створюємо множини з масивів
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        // Залишаємо лише ті елементи, які є в обох множинах
        set1.retainAll(set2);

        // Перетворюємо результат на масив
        int[] result = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            result[i++] = num;
        }

        return result;
    }
}

