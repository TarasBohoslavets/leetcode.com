package Problem_List.Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println ( solution.maxProfit ( prices1 ) );

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println ( solution.maxProfit ( prices2 ) );
    }

    public int maxProfit ( int[] prices ) {
        if ( prices == null || prices.length == 0 ) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if ( price < minPrice ) {
                minPrice = price;
            } else if ( price - minPrice > maxProfit ) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}

