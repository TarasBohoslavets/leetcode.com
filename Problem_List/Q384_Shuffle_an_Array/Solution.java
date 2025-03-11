package Problem_List.Q384_Shuffle_an_Array;

import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] original; // Початковий масив для збереження вихідного порядку
    private int[] array; // Поточний масив для перемішування
    private Random rand; // Генератор випадкових чисел

    // Конструктор: отримує масив і створює його копії
    public Solution(int[] nums) {
        original = nums.clone();
        array = nums.clone();
        rand = new Random();
    }

    // Метод скидання масиву до початкового стану
    public int[] reset() {
        array = original.clone();
        return array;
    }

    // Метод перемішування масиву з використанням алгоритму Фішера-Йетса
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // Випадковий індекс у межах [0, i]
            swap(i, j);
        }
        return array;
    }

    // Допоміжний метод для обміну двох елементів масиву
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

// Приклад використання
class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        System.out.println("Original: " + Arrays.toString(solution.reset()));
        System.out.println("Shuffled: " + Arrays.toString(solution.shuffle()));
        System.out.println("Reset: " + Arrays.toString(solution.reset()));
        System.out.println("Shuffled again: " + Arrays.toString(solution.shuffle()));
    }
}

