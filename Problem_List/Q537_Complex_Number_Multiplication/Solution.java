package Problem_List.Q537_Complex_Number_Multiplication;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] comp1 = parse(num1);
        int[] comp2 = parse(num2);

        int realPart = comp1[0] * comp2[0] - comp1[1] * comp2[1];
        int imagPart = comp1[0] * comp2[1] + comp1[1] * comp2[0];

        return realPart + "+" + imagPart + "i";
    }

    private int[] parse(String num) {
        String[] parts = num.split("\\+");
        int real = Integer.parseInt(parts[0]);
        int imag = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1)); // remove 'i'
        return new int[]{real, imag};
    }
}

