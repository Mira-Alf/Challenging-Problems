import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toLowerCase();
        String substring = "the".toLowerCase();
        int stringIndex = 0, substringLength = 3, foundIndex = -1;
        while( stringIndex < inputString.length() ) {
            int startIndex = stringIndex, endIndex = stringIndex+3;
            if( endIndex <= inputString.length() && inputString.substring(startIndex,endIndex).equals(substring) ) {
                foundIndex = stringIndex;
                break;
            }
            stringIndex++;
        }
        System.out.printf("%d", foundIndex);
    }
}