package Problem_List.Q258_Add_Digits;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38)); // Output: 2
        System.out.println(sol.addDigits(0));  // Output: 0
        System.out.println(sol.addDigits(123)); // Output: 6
    }

    public int addDigits(int num) {
        if (num == 0) { //Якщо число дорівнює 0, результат одразу буде 0
            return 0;
        } else if (num % 9 == 0) { //Якщо число кратне 9 (крім нуля), результат завжди буде 9
            return 9;
        } else {
            return num % 9; //В інших випадках результатом буде залишок від ділення числа на 9
        }
    }
}

