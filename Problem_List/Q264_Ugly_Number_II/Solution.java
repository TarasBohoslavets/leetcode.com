package Problem_List.Q264_Ugly_Number_II;

class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int pointer2 = 0, pointer3 = 0, pointer5 = 0;

        for (int i = 1; i < n; i++) {
            // Calculate the next possible ugly numbers
            int nextMultipleOf2 = uglyNumbers[pointer2] * 2;
            int nextMultipleOf3 = uglyNumbers[pointer3] * 3;
            int nextMultipleOf5 = uglyNumbers[pointer5] * 5;

            // Find the minimum of the three
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUgly;

            // Move the pointer(s) corresponding to the chosen number
            if (nextUgly == nextMultipleOf2) pointer2++;
            if (nextUgly == nextMultipleOf3) pointer3++;
            if (nextUgly == nextMultipleOf5) pointer5++;
        }

        return uglyNumbers[n - 1];
    }
}

