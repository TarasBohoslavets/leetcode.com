package Problem_List.Q17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        letterCombinationsRecursive(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void letterCombinationsRecursive(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            letterCombinationsRecursive(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();

        String digits1 = "23";
        System.out.println(solution.letterCombinations(digits1)); // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        String digits2 = "";
        System.out.println(solution.letterCombinations(digits2)); // Output: []

        String digits3 = "2";
        System.out.println(solution.letterCombinations(digits3)); // Output: ["a", "b", "c"]
    }
}

