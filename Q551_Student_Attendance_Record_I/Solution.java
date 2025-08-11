package Q551_Student_Attendance_Record_I;

public class Solution {
    public boolean checkRecord(String s) {
        int absents = 0;
        int lateStreak = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absents++;
                if (absents >= 2) return false;
                lateStreak = 0;
            } else if (c == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false;
            } else {
                lateStreak = 0;
            }
        }

        return true;

//        return s.indexOf("LLL") == -1 && s.chars().filter(c -> c == 'A').count() < 2;
    }
}
