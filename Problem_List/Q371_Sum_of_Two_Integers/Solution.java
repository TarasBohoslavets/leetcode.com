package Problem_List.Q371_Sum_of_Two_Integers;

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // знайдемо перенос
            a = a ^ b; // виконуємо додавання без переносу
            b = carry; // перенос додаємо на наступній ітерації
        }
        return a;
    }
}
