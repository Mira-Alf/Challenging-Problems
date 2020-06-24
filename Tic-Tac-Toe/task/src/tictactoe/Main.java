package tictactoe;
import java.util.Scanner;
public class Main {

    public static void printFieldBoundary() {
        for( int i = 0; i < 9; i++)     {
            System.out.printf("%c", '-');
        }
        System.out.println();
    }

    public static void printBox( char[] charArray ) {
        printFieldBoundary();
        for( int i = 0; i < 3; i++ ) {
            System.out.printf("%c ", '|' );
            for( int j = 0; j < 3; j++ ) {
                System.out.printf("%c ", charArray[3*i+j]);
            }
            System.out.printf("%c%n", '|');
        }
        printFieldBoundary();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String cells = scanner.next();
        printBox(cells.toCharArray());
    }
}
