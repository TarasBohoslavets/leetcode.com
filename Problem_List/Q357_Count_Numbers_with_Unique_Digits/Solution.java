package Problem_List.Q357_Count_Numbers_with_Unique_Digits;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int uniqueCount = 10; // for n = 1 (0-9)
        int availableDigits = 9;
        int currentUniqueNumbers = 9;

        for (int i = 2; i <= n; i++) {
            currentUniqueNumbers *= availableDigits;
            uniqueCount += currentUniqueNumbers;
            availableDigits--;
        }

        return uniqueCount;
    }
}