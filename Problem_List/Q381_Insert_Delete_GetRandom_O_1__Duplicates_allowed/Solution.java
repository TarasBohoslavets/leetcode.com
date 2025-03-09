package Problem_List.Q381_Insert_Delete_GetRandom_O_1__Duplicates_allowed;

import java.util.*;

class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> indices;
    private Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
    }

    // Вставка нового елемента в колекцію
    public boolean insert(int val) {
        boolean notPresent = !indices.containsKey(val);
        indices.putIfAbsent(val, new HashSet<>());
        indices.get(val).add(nums.size());
        nums.add(val);
        return notPresent;
    }

    // Видалення елемента з колекції
    public boolean remove(int val) {
        if (!indices.containsKey(val) || indices.get(val).isEmpty()) {
            return false;
        }

        int removeIdx = indices.get(val).iterator().next();
        indices.get(val).remove(removeIdx);

        int lastElement = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastElement);

        indices.get(lastElement).add(removeIdx);
        indices.get(lastElement).remove(nums.size() - 1);

        nums.remove(nums.size() - 1);

        if (indices.get(val).isEmpty()) {
            indices.remove(val);
        }

        return true;
    }

    // Отримання випадкового елемента
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        System.out.println(obj.insert(1)); // true
        System.out.println(obj.insert(1)); // false
        System.out.println(obj.insert(2)); // true
        System.out.println(obj.getRandom()); // може бути 1 або 2
        System.out.println(obj.remove(1)); // true
        System.out.println(obj.getRandom()); // може бути 1 або 2
    }
}