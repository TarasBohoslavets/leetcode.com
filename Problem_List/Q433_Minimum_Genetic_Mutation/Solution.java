package Problem_List.Q433_Minimum_Genetic_Mutation;

import java.util.*;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String gene = current.gene;
            int mutations = current.mutations;

            if (gene.equals(endGene)) return mutations;

            for (int i = 0; i < gene.length(); i++) {
                char[] geneArray = gene.toCharArray();
                for (char c : genes) {
                    if (geneArray[i] == c) continue;
                    geneArray[i] = c;
                    String mutated = new String(geneArray);
                    if (bankSet.contains(mutated)) {
                        queue.offer(new Pair(mutated, mutations + 1));
                        bankSet.remove(mutated);
                    }
                }
            }
        }

        return -1;
    }

    private static class Pair {
        String gene;
        int mutations;

        Pair(String gene, int mutations) {
            this.gene = gene;
            this.mutations = mutations;
        }
    }
}

