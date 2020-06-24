import java.util.Scanner;
class Main {

    public static int getSum( String ticketNumber, boolean isFirstHalf ) {
        String ticketSubString = isFirstHalf ? ticketNumber.substring(0, 3) : ticketNumber.substring(3);
        int count = 0, sum = 0;
        for( char c : ticketSubString.toCharArray()) {
            sum += Character.getNumericValue(c);
            count++;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticketNumber = scanner.next();
        if( ticketNumber.length() == 6 ) {
            if( getSum(ticketNumber,true) == getSum(ticketNumber, false) )
                System.out.println("Lucky");
            else
                System.out.println("Regular");
        }
    }
}