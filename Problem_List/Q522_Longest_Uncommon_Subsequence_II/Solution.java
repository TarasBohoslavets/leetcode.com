package Problem_List.Q522_Longest_Uncommon_Subsequence_II;

class Solution {
    public int findLUSlength(String[] strs) {
        int res = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;

            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }

            if (isUncommon) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
}
