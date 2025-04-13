package Problem_List.Q420_Strong_Password_Checker;


class Solution {
    public int strongPasswordChecker(String password) {
        int len = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        int replace = 0;
        int oneMod = 0, twoMod = 0;

        // Count missing character types
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        // Count repeating sequences
        for (int i = 2; i < len; ) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                int j = i - 2;
                while (i < len && password.charAt(i) == password.charAt(j)) i++;
                int repeatLen = i - j;
                replace += repeatLen / 3;
                if (repeatLen % 3 == 0) oneMod++;
                else if (repeatLen % 3 == 1) twoMod++;
                // else %3 == 2 -> we handle it later
            } else {
                i++;
            }
        }

        if (len < 6) {
            return Math.max(missingTypes, 6 - len);
        } else if (len <= 20) {
            return Math.max(missingTypes, replace);
        } else {
            int delete = len - 20;
            int remainingDelete = delete;

            // Try to use deletions to reduce replacements
            int reduce = 0;
            if (remainingDelete > 0) {
                int use = Math.min(oneMod, remainingDelete);
                replace -= use;
                remainingDelete -= use;
            }
            if (remainingDelete > 0) {
                int use = Math.min(twoMod * 2, remainingDelete);
                replace -= use / 2;
                remainingDelete -= use;
            }
            if (remainingDelete > 0) {
                replace -= remainingDelete / 3;
            }

            return delete + Math.max(missingTypes, replace);
        }
    }
}

