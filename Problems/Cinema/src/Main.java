import java.util.Scanner;

class Main {
    public static int getRowWithKConsecutiveSeats( int[][] seatsArray, int consecutiveSeats ) {
        boolean isConsecutive = false;
        int k = 0;
        for( int i = 0; i < seatsArray.length; i++ ) {
            for( int j = 0; j < seatsArray[i].length; j++ ) {
                if( seatsArray[i][j] == 0 && !isConsecutive ) {
                    k = 1;
                    isConsecutive = true;
                }
                else if( seatsArray[i][j] == 0 && isConsecutive )
                    k++;
                else if( seatsArray[i][j] == 1 ) {
                    k = 0;
                    isConsecutive = false;
                }
                if( k == consecutiveSeats )
                    return i+1;
            }
            k = 0;
            isConsecutive = false;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] seatsArray = new int[rows][columns];

        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++ ) {
                seatsArray[i][j] = scanner.nextInt();
            }
        }
        int consecutiveSeats = scanner.nextInt();
        System.out.println( getRowWithKConsecutiveSeats(seatsArray,consecutiveSeats) );
    }
}