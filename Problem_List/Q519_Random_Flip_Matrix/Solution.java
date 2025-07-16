package Problem_List.Q519_Random_Flip_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private int m, n, total;
    private Map<Integer, Integer> map;
    private Random rand;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    public int[] flip() {
        int r = rand.nextInt(total--); // випадкове число у діапазоні [0, total)
        int x = map.getOrDefault(r, r); // беремо актуальний індекс
        int last = map.getOrDefault(total, total); // останній доступний

        map.put(r, last); // поміняли місцями r і останній
        return new int[]{x / n, x % n}; // переводимо в координати [i, j]
    }

    public void reset() {
        map.clear();
        total = m * n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(3, 1);

        int[] f1 = solution.flip();  // можливі: [0,0], [1,0], [2,0]
        System.out.println(java.util.Arrays.toString(f1));

        int[] f2 = solution.flip();  // можливі з тих, що залишились
        System.out.println(java.util.Arrays.toString(f2));

        int[] f3 = solution.flip();  // останній, що ще залишився
        System.out.println(java.util.Arrays.toString(f3));

        solution.reset();  // всі клітинки знову 0

        int[] f4 = solution.flip();  // знову [0,0], [1,0], [2,0] можливі
        System.out.println(java.util.Arrays.toString(f4));
    }
}