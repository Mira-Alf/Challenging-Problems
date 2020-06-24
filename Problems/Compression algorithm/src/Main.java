import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        char prevChar = '\u0000';
        int frequency = 0;
        StringBuilder builder = new StringBuilder();
        for( char c : inputLine.toCharArray() ) {
            if( prevChar == '\u0000') {
                prevChar = c;
                frequency++;
                builder.append(c);
            } else {
                if( c == prevChar ) {
                    frequency++;
                } else {
                    builder.append(frequency).append(c);
                    frequency = 1;
                    prevChar = c;
                }
            }
        }
        builder.append(frequency);
        System.out.println(builder.toString());
    }
}