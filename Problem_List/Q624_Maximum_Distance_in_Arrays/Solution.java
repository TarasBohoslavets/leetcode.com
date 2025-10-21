package Problem_List.Q624_Maximum_Distance_in_Arrays;

import java.util.List;

class Solution {
	public int maxDistance(List<List<Integer>> arrays) {
		int maxDist = 0;
		int minVal = arrays.get(0).get(0);
		int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
		
		for (int i = 1; i < arrays.size(); i++) {
			int currMin = arrays.get(i).get(0);
			int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
			
			maxDist = Math.max(maxDist, Math.abs(currMax - minVal));
			maxDist = Math.max(maxDist, Math.abs(maxVal - currMin));
			
			minVal = Math.min(minVal, currMin);
			maxVal = Math.max(maxVal, currMax);
		}
		
		return maxDist;
	}
}