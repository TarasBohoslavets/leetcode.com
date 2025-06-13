package Problem_List.Q495_Teemo_Attacking;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int totalTime = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            // Якщо поточна атака відбувається ДО закінчення попередньої, враховуємо перекриття
            totalTime += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }

        // Додаємо отруєння від останньої атаки
        return totalTime + duration;
    }

    public static void main(String[] args) {
        TeemoAttacking solver = new TeemoAttacking();

        int[] timeSeries1 = {1, 4};
        int duration1 = 2;
        System.out.println(solver.findPoisonedDuration(timeSeries1, duration1)); // Виведе 4

        int[] timeSeries2 = {1, 2};
        int duration2 = 2;
        System.out.println(solver.findPoisonedDuration(timeSeries2, duration2)); // Виведе 3
    }
}

