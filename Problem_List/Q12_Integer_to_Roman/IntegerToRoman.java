package Problem_List.Q12_Integer_to_Roman;

/*
class Solution {
    public String intToRoman(int num) {
    final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final String[] symbols = {"M",  "CM", "D",  "CD", "C",  "XC", "L","XL", "X",  "IX", "V",  "IV", "I"};
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < values.length; ++i) {
      if (num == 0)
        break;
      while (num >= values[i]) {
        num -= values[i];
        sb.append(symbols[i]);
      }
    }

    return sb.toString();
    }
}
* */



public class IntegerToRoman {

    // Arrays to store Roman numeral symbols and their corresponding values
    private static final String[] ROMAN_SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRoman(int num) {


        StringBuilder roman = new StringBuilder();

        // Iterate over the values array
        for (int i = 0; i < VALUES.length; i++) {
            // Find how many times the current value can fit into num
            while (num >= VALUES[i]) {
                // Append the corresponding Roman symbol to the result
                roman.append(ROMAN_SYMBOLS[i]);
                // Subtract the value from num
                num -= VALUES[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3749)); // Output: MMMDCCXLIX
        System.out.println(intToRoman(58));   // Output: LVIII
        System.out.println(intToRoman(1994)); // Output: MCMXCIV
    }
}

