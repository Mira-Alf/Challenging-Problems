import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String substring = scanner.nextLine();
        int stringIndex = 0, substringLength = substring.length(), frequency = 0;
        while( stringIndex < inputString.length() ) {
            int startIndex = stringIndex, endIndex = startIndex+substringLength;
            if( endIndex <= inputString.length() &&
                    inputString.substring(stringIndex,stringIndex+substringLength).equals(substring) ) {
                frequency++;
                stringIndex = stringIndex + substringLength;
            }
            stringIndex++;
        }
        System.out.println(frequency);
    }
}