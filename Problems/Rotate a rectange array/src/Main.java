import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int originalRows = scanner.nextInt();
        int originalColumns = scanner.nextInt();
        int[][] rectangleArray = new int[originalRows][originalColumns];
        for( int i = 0; i < originalRows; i++ ) {
            for( int j = 0; j < originalColumns; j++ ) {
                rectangleArray[i][j] = scanner.nextInt();
            }
        }
        int[][] resultArray = new int[originalColumns][originalRows];
        for( int i = originalRows-1; i >= 0; i-- ) {
            for( int j = 0; j < originalColumns; j++ ) {
                resultArray[j][originalRows-1-i] = rectangleArray[i][j];
            }
        }
        for( int i = 0; i < originalColumns; i++ ) {
            for( int j = 0; j < originalRows; j++ ) {
                System.out.print(resultArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}