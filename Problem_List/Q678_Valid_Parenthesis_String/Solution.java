package Problem_List.Q678_Valid_Parenthesis_String;

class Solution {
	public boolean checkValidString(String s) {
		int low = 0, high = 0;
		
		for (char c : s.toCharArray()) {
			if (c == '(') {
				low++;
				high++;
			} else if (c == ')') {
				if (low > 0) low--;
				high--;
			} else { // '*'
				if (low > 0) low--; // treat '*' as ')'
				high++;             // treat '*' as '('
			}
			
			if (high < 0) return false; // too many ')'
		}
		
		return low == 0;
	}
}