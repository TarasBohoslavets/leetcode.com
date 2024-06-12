package Problem_List.Valid_Phone_Numbers_193;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main ( String[] args ) {
        String fileName = "file.txt"; // Specify the path to your file

        // Define the regex pattern for valid phone numbers
        String regex = "^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$";
        Pattern pattern = Pattern.compile ( regex );

        try (BufferedReader br = new BufferedReader ( new FileReader ( fileName ) )) {
            String line;
            while ((line = br.readLine ( )) != null) {
                Matcher matcher = pattern.matcher ( line );
                if ( matcher.matches ( ) ) {
                    System.out.println ( line );
                }
            }
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }
}

