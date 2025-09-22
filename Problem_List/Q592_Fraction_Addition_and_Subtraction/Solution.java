package Problem_List.Q592_Fraction_Addition_and_Subtraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public String fractionAddition(String expression) {
		int numerator = 0, denominator = 1;
		
		// Regular expression to match fractions
		Pattern pattern = Pattern.compile("[-+]?[0-9]+/[0-9]+");
		Matcher matcher = pattern.matcher(expression);
		
		while (matcher.find()) {
			String[] parts = matcher.group().split("/");
			int num = Integer.parseInt(parts[0]);
			int den = Integer.parseInt(parts[1]);
			
			// Add current fraction to total
			numerator = numerator * den + num * denominator;
			denominator *= den;
			
			// Simplify
			int gcd = gcd(Math.abs(numerator), denominator);
			numerator /= gcd;
			denominator /= gcd;
		}
		
		return numerator + "/" + denominator;
	}
	
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
