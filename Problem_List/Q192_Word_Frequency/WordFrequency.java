package Problem_List.Q192_Word_Frequency;

//tr -s ' ' '\n' < words.txt | sort | uniq -c | sort -nr | awk '{print $2, $1}'

import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        // Read the file
        File file = new File("words.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // Map to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            // Split line into words, handle multiple spaces
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();

        // Sort words by frequency (descending) and then alphabetically
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue(); // Descending by frequency
            }
            return a.getKey().compareTo(b.getKey()); // Alphabetically
        });

        // Print results
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

