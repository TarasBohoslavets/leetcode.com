package Problem_List.Q134_Gas_Station;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) { // Якщо баланс палива стає від’ємним
                startStation = i + 1; // Починаємо з наступної станції
                currentGas = 0; // Скидаємо поточний баланс
            }
        }

        // Перевірка, чи можемо об'їхати круг
        return totalGas >= totalCost ? startStation : -1;
    }
}

