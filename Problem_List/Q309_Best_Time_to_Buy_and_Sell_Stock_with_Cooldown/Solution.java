package Problem_List.Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int hold = -prices[0]; // Якщо купили акцію на 0-му дні
        int sell = 0;          // Якщо продаємо (початково неможливо)
        int cooldown = 0;      // Стан "відпочинку" (початково нуль)

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSell = sell;
            int prevCooldown = cooldown;

            hold = Math.max(prevHold, prevCooldown - prices[i]); // Купуємо або утримуємо
            sell = prevHold + prices[i]; // Продаємо
            cooldown = Math.max(prevCooldown, prevSell); // Охолодження або залишаємося

        }

        return Math.max(sell, cooldown); // Максимальний прибуток буде або у стані продажу, або в cooldown
    }
}
