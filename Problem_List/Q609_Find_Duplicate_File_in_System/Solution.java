package Problem_List.Q609_Find_Duplicate_File_in_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> contentToPaths = new HashMap<>();
		
		for (String entry : paths) {
			String[] parts = entry.split(" ");
			String dir = parts[0];
			
			for (int i = 1; i < parts.length; i++) {
				String file = parts[i];
				int idx = file.indexOf('(');
				String name = file.substring(0, idx);
				String content = file.substring(idx + 1, file.length() - 1);
				String fullPath = dir + "/" + name;
				
				contentToPaths.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
			}
		}
		
		List<List<String>> result = new ArrayList<>();
		for (List<String> group : contentToPaths.values()) {
			if (group.size() > 1) {
				result.add(group);
			}
		}
		
		return result;
	}
}
