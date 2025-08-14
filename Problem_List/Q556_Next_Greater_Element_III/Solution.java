package Problem_List.Q556_Next_Greater_Element_III;

class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        // Крок 1: знайти перший спад
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) return -1;  // вже найбільша перестановка

        // Крок 2: знайти найменшу більшу цифру справа
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Крок 3: поміняти місцями
        swap(digits, i, j);

        // Крок 4: розвернути хвіст
        reverse(digits, i + 1, digits.length - 1);

        // Крок 5: перетворити назад у число
        long val = Long.parseLong(new String(digits));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
