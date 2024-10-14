package Problem_List.Q367_Valid_Perfect_Square;

class Solution {


    public boolean isPerfectSquare ( int num ) {
        if ( num < 1 ) {
            return false; // Відразу повертаємо false, якщо num менше 1
        }

        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if ( square == num ) {
                return true; // Якщо знайдено perfect square, повертаємо true
            } else if ( square < num ) {
                left = mid + 1; // Переміщуємо ліву межу вправо
            } else {
                right = mid - 1; // Переміщуємо праву межу вліво
            }
        }

        return false; // Якщо не знайдено perfect square, повертаємо false
    }

}