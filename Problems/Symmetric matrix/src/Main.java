import java.util.Scanner;

class Main {
    public static boolean isSymmetricalMatrix( int[][] matrix ) {
        int sizeOfMatrix = matrix.length;
        for( int i = 0; i < sizeOfMatrix; i++ ) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if( i != j ) {
                    if( matrix[i][j] != matrix[j][i] )
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = scanner.nextInt();
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for( int i = 0; i < sizeOfMatrix; i++ ) {
            for( int j = 0; j < sizeOfMatrix; j++ ) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(isSymmetricalMatrix(matrix) ? "YES" : "NO" );
    }
}