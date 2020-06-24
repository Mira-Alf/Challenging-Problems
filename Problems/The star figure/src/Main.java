import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = scanner.nextInt();
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
        for( int i = 0; i < sizeOfMatrix; i++ ) {
            for( int j = 0; j < sizeOfMatrix; j++ ) {
                if( i == j || (i+j) == sizeOfMatrix-1 || i == sizeOfMatrix/2 || j == sizeOfMatrix/2 )
                    matrix[i][j] = '*';
                else
                    matrix[i][j] = '.';
            }
        }
        for( char[] rows : matrix ) {
            for( char element : rows ) {
                System.out.print( element+ " " );
            }
            System.out.println();
        }
    }
}