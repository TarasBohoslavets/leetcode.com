package Problem_List.Q640_Solve_the_Equation;

class Solution {
	public String solveEquation(String equation) {
		String[] parts = equation.split("=");
		int[] left = evaluate(parts[0]);
		int[] right = evaluate(parts[1]);
		
		int xCoeff = left[0] - right[0];
		int constSum = right[1] - left[1];
		
		if (xCoeff == 0 && constSum == 0) return "Infinite solutions";
		if (xCoeff == 0) return "No solution";
		
		return "x=" + (constSum / xCoeff);
	}
	
	private int[] evaluate(String expr) {
		int xCoeff = 0, constSum = 0;
		int i = 0, sign = 1;
		
		while (i < expr.length()) {
			if (expr.charAt(i) == '+') {
				sign = 1;
				i++;
			} else if (expr.charAt(i) == '-') {
				sign = -1;
				i++;
			}
			
			int num = 0;
			boolean hasNum = false;
			
			while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
				num = num * 10 + (expr.charAt(i) - '0');
				i++;
				hasNum = true;
			}
			
			if (i < expr.length() && expr.charAt(i) == 'x') {
				xCoeff += sign * (hasNum ? num : 1);
				i++;
			} else {
				constSum += sign * num;
			}
		}
		
		return new int[]{xCoeff, constSum};
	}
}
