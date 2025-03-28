package Problem_List.Q401_Binary_Watch;

import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Перебираємо всі можливі значення годин (0-11) та хвилин (0-59)
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Підраховуємо кількість одиниць у двійковому представленні
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        System.out.println(bw.readBinaryWatch(1));
    }
}

