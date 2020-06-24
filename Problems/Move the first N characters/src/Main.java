import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int numLetters = scanner.nextInt();
        if( numLetters > input.length() )
            System.out.println(input);
        else {
            StringBuilder builder = new StringBuilder();
            builder.append(input.substring(numLetters)).append(input.substring(0, numLetters));
            System.out.println(builder.toString());
        }

    }
}
