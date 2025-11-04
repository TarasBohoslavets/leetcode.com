package Problem_List.Q638_Shopping_Offers;

import java.util.*;

class Solution {
	Map<List<Integer>, Integer> memo = new HashMap<>();
	
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return dfs(price, special, needs);
	}
	
	private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		if (memo.containsKey(needs)) return memo.get(needs);
		
		int minCost = directPurchase(price, needs);
		
		for (List<Integer> offer : special) {
			List<Integer> updatedNeeds = new ArrayList<>();
			boolean valid = true;
			
			for (int i = 0; i < needs.size(); i++) {
				if (offer.get(i) > needs.get(i)) {
					valid = false;
					break;
				}
				updatedNeeds.add(needs.get(i) - offer.get(i));
			}
			
			if (valid) {
				int offerCost = offer.get(offer.size() - 1) + dfs(price, special, updatedNeeds);
				minCost = Math.min(minCost, offerCost);
			}
		}
		
		memo.put(needs, minCost);
		return minCost;
	}
	
	private int directPurchase(List<Integer> price, List<Integer> needs) {
		int total = 0;
		for (int i = 0; i < price.size(); i++) {
			total += price.get(i) * needs.get(i);
		}
		return total;
	}
}
