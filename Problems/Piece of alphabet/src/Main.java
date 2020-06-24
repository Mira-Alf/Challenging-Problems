import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabets = scanner.next().toCharArray();
        boolean isOrdered = true;
        char a = alphabets[0];
        for( int i = 1; i < alphabets.length; i++ ) {
            if( alphabets[i] - a != 1 ) {
                isOrdered = false;
                break;
            }
            a = alphabets[i];
        }
        System.out.println(isOrdered);
    }
}