package Problem_List.Q648_Replace_Words;

import java.util.List;

class Solution {
	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word; // зберігаємо корінь, якщо він закінчується тут
	}
	
	private TrieNode root = new TrieNode();
	
	private void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new TrieNode();
			}
			node = node.children[idx];
		}
		node.word = word; // позначаємо кінець кореня
	}
	
	private String findRoot(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (node.children[idx] == null) break;
			node = node.children[idx];
			if (node.word != null) return node.word; // знайшли найкоротший корінь
		}
		return word; // якщо корінь не знайдено
	}
	
	public String replaceWords(List<String> dictionary, String sentence) {
		for (String rootWord : dictionary) {
			insert(rootWord);
		}
		
		StringBuilder sb = new StringBuilder();
		for (String word : sentence.split(" ")) {
			if (sb.length() > 0) sb.append(" ");
			sb.append(findRoot(word));
		}
		
		return sb.toString();
	}
}
