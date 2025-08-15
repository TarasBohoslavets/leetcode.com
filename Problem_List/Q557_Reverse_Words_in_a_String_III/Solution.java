package Problem_List.Q557_Reverse_Words_in_a_String_III;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();  // видаляємо зайвий пробіл в кінці
    }
}
