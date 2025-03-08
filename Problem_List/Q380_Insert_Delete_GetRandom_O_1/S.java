package Problem_List.Q380_Insert_Delete_GetRandom_O_1;

import java.util.*;

class RandomizedSet {
    // Хеш-мапа для збереження значення та його індексу у списку
    private Map<Integer, Integer> map;
    // Список для збереження елементів у порядку вставки
    private List<Integer> list;
    // Генератор випадкових чисел
    private Random rand;

    // Конструктор ініціалізує структури даних
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    // Додає елемент у множину, якщо його ще немає
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Число вже є в множині
        }
        map.put(val, list.size()); // Зберігаємо індекс у списку
        list.add(val); // Додаємо елемент у список
        return true;
    }

    // Видаляє елемент, якщо він є у множині
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Числа немає у множині
        }
        int lastElement = list.get(list.size() - 1); // Отримуємо останній елемент
        int index = map.get(val); // Отримуємо індекс елемента, що видаляється

        // Замінюємо елемент, що видаляється, на останній у списку
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Видаляємо останній елемент зі списку та хеш-мапи
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Повертає випадковий елемент з множини
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 або 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2 (єдиний елемент)
    }
}