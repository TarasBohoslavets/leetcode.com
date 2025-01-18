package Problem_List.Q284_Peeking_Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;
import java.util.Arrays;


class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator; // Основний ітератор
    private Integer nextElement;        // Попередньо збережений елемент

    public PeekingIterator(Iterator<Integer> iterator) {
        // Ініціалізація ітератора та попереднього елемента
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next(); // Завантажуємо перший елемент
        }
    }

    // Повертає наступний елемент у послідовності без переміщення вказівника
    public Integer peek() {
        return nextElement; // Повертаємо збережений елемент
    }

    // Повертає наступний елемент у послідовності та переміщує вказівник вперед
    @Override
    public Integer next() {
        if (nextElement == null) {
            throw new java.util.NoSuchElementException(); // Кидаємо виключення, якщо немає елементів
        }
        Integer current = nextElement; // Зберігаємо поточний елемент
        nextElement = iterator.hasNext() ? iterator.next() : null; // Оновлюємо збережений елемент
        return current;
    }

    // Перевіряє, чи є ще елементи в ітераторі
    @Override
    public boolean hasNext() {
        return nextElement != null; // Якщо є збережений елемент, повертаємо true
    }


    public class Main {
        public static void main(String[] args) {
            Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
            PeekingIterator peekingIterator = new PeekingIterator(iterator);

            System.out.println(peekingIterator.next());    // Повертає 1
            System.out.println(peekingIterator.peek());    // Повертає 2
            System.out.println(peekingIterator.next());    // Повертає 2
            System.out.println(peekingIterator.next());    // Повертає 3
            System.out.println(peekingIterator.hasNext()); // Повертає false
        }
    }
}
