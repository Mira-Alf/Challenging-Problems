import java.util.Scanner;
class Main {

    public static void printCharacterTwice( char ch ) {
        int count = 0;
        while( count < 2 ) {
            System.out.printf("%c", ch);
            count++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for( char ch : line.toCharArray() ) {
            printCharacterTwice(ch);
        }
    }
}