import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] inputTokens = inputLine.split("\\s+");
        int maxLength = inputTokens[0].length();
        String output = inputTokens[0];
        for( String s : inputTokens ) {
            if( s.length() > maxLength ) {
                output = s;
                maxLength = output.length();
            }
        }
        System.out.println(output);
    }
}