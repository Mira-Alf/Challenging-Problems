import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] twoDArray = new int[rows][columns];
        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++ ) {
                twoDArray[i][j] = scanner.nextInt();
            }
        }
        int oldCol = scanner.nextInt();
        int newCol = scanner.nextInt();

        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++ ) {
                int elem;
                if( j == oldCol )
                    elem = twoDArray[i][newCol];
                else if( j == newCol )
                    elem = twoDArray[i][oldCol];
                else
                    elem = twoDArray[i][j];
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }
}