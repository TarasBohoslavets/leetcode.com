package Problem_List.Q71_Simplify_Path;

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        // Стек для зберігання компонентів шляху
        Deque<String> stack = new LinkedList<>();
        // Розділяємо шлях на компоненти за '/'
        String[] components = path.split("/");

        for (String component : components) {
            // Ігноруємо порожні компоненти або '.'
            if (component.equals("") || component.equals(".")) {
                continue;
            }
            // Якщо зустріли '..', піднімаємося на рівень вище (якщо можливо)
            else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // Додаємо валідну директорію в стек
            else {
                stack.push(component);
            }
        }

        // Формуємо кінцевий шлях
        StringBuilder simplifiedPath = new StringBuilder();

        // Якщо стек порожній, повертаємо кореневий каталог "/"
        if (stack.isEmpty()) {
            return "/";
        }

        // Об'єднуємо всі елементи зі стеку у форматі "/dir"
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, "/" + stack.pop());
        }

        return simplifiedPath.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println(solution.simplifyPath("/home/")); // Output: "/home"

        // Example 2
        System.out.println(solution.simplifyPath("/home//foo/")); // Output: "/home/foo"

        // Example 3
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures")); // Output: "/home/user/Pictures"

        // Example 4
        System.out.println(solution.simplifyPath("/../")); // Output: "/"

        // Example 5
        System.out.println(solution.simplifyPath("/.../a/../b/c/../d/./")); // Output: "/.../b/d"
    }
}

