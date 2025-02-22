package Problem_List.Q352_Data_Stream_as_Disjoint_Intervals;

import java.util.Arrays;
import java.util.TreeMap;

class SummaryRanges {
    private TreeMap<Integer, int[]> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {
        if (intervals.containsKey(value)) {
            return;
        }

        Integer lowerKey = intervals.floorKey(value);
        Integer higherKey = intervals.ceilingKey(value);

        boolean mergeLeft = lowerKey != null && intervals.get(lowerKey)[1] + 1 >= value;
        boolean mergeRight = higherKey != null && higherKey - 1 <= value;

        if (mergeLeft && mergeRight) {
            int[] lowerInterval = intervals.get(lowerKey);
            int[] higherInterval = intervals.get(higherKey);
            lowerInterval[1] = higherInterval[1];
            intervals.remove(higherKey);
        } else if (mergeLeft) {
            intervals.get(lowerKey)[1] = Math.max(intervals.get(lowerKey)[1], value);
        } else if (mergeRight) {
            int[] rightInterval = intervals.get(higherKey);
            intervals.remove(higherKey);
            intervals.put(value, new int[]{value, rightInterval[1]});
        } else {
            intervals.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        return intervals.values().toArray(new int[intervals.size()][]);
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        System.out.println(Arrays.deepToString(sr.getIntervals())); // [[1, 1]]

        sr.addNum(3);
        System.out.println(Arrays.deepToString(sr.getIntervals())); // [[1, 1], [3, 3]]

        sr.addNum(7);
        System.out.println(Arrays.deepToString(sr.getIntervals())); // [[1, 1], [3, 3], [7, 7]]

        sr.addNum(2);
        System.out.println(Arrays.deepToString(sr.getIntervals())); // [[1, 3], [7, 7]]

        sr.addNum(6);
        System.out.println(Arrays.deepToString(sr.getIntervals())); // [[1, 3], [6, 7]]
    }
}
