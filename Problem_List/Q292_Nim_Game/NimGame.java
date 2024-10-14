package Problem_List.Q292_Nim_Game;

public class NimGame {
    public static void main ( String[] args ) {
        NimGame game = new NimGame ( );

        // Test cases
        System.out.println ( game.canWinNim ( 4 ) ); // Output: false
        System.out.println ( game.canWinNim ( 1 ) ); // Output: true
        System.out.println ( game.canWinNim ( 2 ) ); // Output: true
        System.out.println ( game.canWinNim ( 5 ) ); // Output: true
        System.out.println ( game.canWinNim ( 8 ) ); // Output: false
    }

    public boolean canWinNim ( int n ) {
        return n % 4 != 0;
    }
}

