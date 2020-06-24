import java.util.Scanner;
class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++ ) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        if( rows > 0 && columns > 0) {
            int maxValue = matrix[0][0];
            int rowIndex = 0, columnIndex = 0;
            for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < columns; j++ ) {
                    if( matrix[i][j] > maxValue ) {
                        maxValue = matrix[i][j];
                        rowIndex = i;
                        columnIndex = j;
                    }
                }
            }
            System.out.printf( "%d %d", rowIndex, columnIndex);
        }

    }
}