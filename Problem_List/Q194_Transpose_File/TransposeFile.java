package Problem_List.Q194_Transpose_File;

import java.io.*;
import java.util.*;

public class TransposeFile {
    public static void main(String[] args) throws IOException {
        // Read the input file
        String inputFileName = "file.txt";
        List<List<String>> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\s+");
                for (int i = 0; i < fields.length; i++) {
                    if (rows.size() <= i) {
                        rows.add(new ArrayList<>());
                    }
                    rows.get(i).add(fields[i]);
                }
            }
        }

        // Write the transposed output
        for (List<String> row : rows) {
            System.out.println(String.join(" ", row));
        }
    }
}

