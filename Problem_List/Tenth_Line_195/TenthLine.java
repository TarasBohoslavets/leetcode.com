package Problem_List.Tenth_Line_195;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TenthLine {
    public static void main ( String[] args ) {
        String fileName = "file.txt"; // Specify the path to your file

        try (BufferedReader br = new BufferedReader ( new FileReader ( fileName ) )) {
            String line;
            int count = 0;

            while ((line = br.readLine ( )) != null) {
                count++;
                if ( count == 10 ) {
                    System.out.println ( line );
                    break;
                }
            }

            if ( count < 10 ) {
                System.out.println ( "The file has less than 10 lines." );
            }
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }
}
