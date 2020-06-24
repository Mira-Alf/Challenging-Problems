import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        char[] charArray = inputString.toCharArray();
        StringBuilder builder = new StringBuilder();
        for( int i = charArray.length-1; i >= 0; i-- ) {
            builder.append(charArray[i]);
        }
        System.out.println(builder.toString().equals(inputString) ? "yes" : "no");
    }
}