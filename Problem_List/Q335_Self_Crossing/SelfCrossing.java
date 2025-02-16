package Problem_List.Q335_Self_Crossing;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) return false; // Не може бути перетину з менше ніж 4 кроками

        for (int i = 3; i < n; i++) {
            // Перетин першого типу: зустріч із 4-ю попередньою лінією
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            // Перетин другого типу: коли 5-та лінія стикається з 1-ю
            if (i >= 4 && distance[i - 1] == distance[i - 3] &&
                    distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            // Перетин третього типу: коли 6-та лінія перекриває другу
            if (i >= 5 && distance[i - 2] >= distance[i - 4] &&
                    distance[i] + distance[i - 4] >= distance[i - 2] &&
                    distance[i - 1] <= distance[i - 3] &&
                    distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SelfCrossing sc = new SelfCrossing();
        System.out.println(sc.isSelfCrossing(new int[]{2, 1, 1, 2})); // true
        System.out.println(sc.isSelfCrossing(new int[]{1, 2, 3, 4})); // false
        System.out.println(sc.isSelfCrossing(new int[]{1, 1, 1, 2, 1})); // true
    }
}
