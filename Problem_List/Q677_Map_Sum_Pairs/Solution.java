package Problem_List.Q677_Map_Sum_Pairs;

import java.util.*;

class MapSum {
	private Map<String, Integer> map;
	
	/** Initialize your data structure here. */
	public MapSum() {
		map = new HashMap<>();
	}
	
	public void insert(String key, int val) {
		map.put(key, val);
	}
	
	public int sum(String prefix) {
		int total = 0;
		for (String key : map.keySet()) {
			if (key.startsWith(prefix)) {
				total += map.get(key);
			}
		}
		return total;
	}
}
