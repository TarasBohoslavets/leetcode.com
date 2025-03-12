package Problem_List.Q385_Mini_Parser;

import java.util.ArrayList;
import java.util.List;

interface NestedInteger {
    // Повертає true, якщо це число, і false, якщо список
    boolean isInteger();

    // Повертає число, якщо це число, або null, якщо це список
    Integer getInteger();

    // Встановлює значення числа
    void setInteger(int value);

    // Додає вкладений об'єкт NestedInteger до списку
    void add(NestedInteger ni);

    // Повертає список, якщо це список, або порожній список, якщо це число
    List<NestedInteger> getList();
}


public class NestedIntegerImpl implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Конструктор для пустого списку
    public NestedIntegerImpl() {
        this.list = new ArrayList<>();
    }

    // Конструктор для числа
    public NestedIntegerImpl(int value) {
        this.value = value;
        this.list = null;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
        this.list = null; // Скидаємо список, бо це число
    }

    @Override
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
            if (value != null) {
                list.add(new NestedIntegerImpl(value)); // Зберігаємо старе значення
                value = null;
            }
        }
        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return list == null ? new ArrayList<>() : list;
    }

    @Override
    public String toString() {
        if (isInteger()) return String.valueOf(value);
        return list.toString();
    }
}

