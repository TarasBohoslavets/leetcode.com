package Problem_List.Q575_Distribute_Candies;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int distributeCandies(int[] candyType) {
		Set<Integer> uniqueTypes = new HashSet<>();
		for (int type : candyType) {
			uniqueTypes.add(type);
		}
		return Math.min(uniqueTypes.size(), candyType.length / 2);
	}
}