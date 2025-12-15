package Problem_List.Q676_Implement_Magic_Dictionary;

import java.util.*;

class MagicDictionary {
	private List<String> dict;
	
	/** Initialize your data structure here. */
	public MagicDictionary() {
		dict = new ArrayList<>();
	}
	
	public void buildDict(String[] dictionary) {
		dict.clear();
		dict.addAll(Arrays.asList(dictionary));
	}
	
	public boolean search(String searchWord) {
		for (String word : dict) {
			if (word.length() != searchWord.length()) continue;
			
			int diff = 0;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != searchWord.charAt(i)) {
					diff++;
					if (diff > 1) break;
				}
			}
			
			if (diff == 1) return true;
		}
		return false;
	}
}
