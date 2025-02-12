package Problem_List.Q331_Verify_Preorder_Serialization_of_a_Binary_Tree;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;  // Починаємо з одного слоту для кореня

        String[] nodes = preorder.split(","); // Розбиваємо рядок на окремі вузли
        for (String node : nodes) {
            slots--;  // Кожен вузол займає один слот

            if (slots < 0) {
                return false;  // Якщо слотів стало менше 0, структура некоректна
            }

            if (!node.equals("#")) {
                slots += 2;  // Якщо вузол не є '#', він додає два нових слоти (для дітей)
            }
        }

        return slots == 0;  // У правильному дереві всі слоти мають бути заповнені
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true
        System.out.println(solution.isValidSerialization("1,#")); // false
        System.out.println(solution.isValidSerialization("9,#,#,1")); // false
    }
}
