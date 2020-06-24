import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = scanner.nextInt();
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for( int i = 0; i < sizeOfMatrix; i++ ) {
            for( int j = 0; j < sizeOfMatrix; j++ ) {
                matrix[i][j] = Math.abs(i-j);
            }
        }

        for( int i = 0; i < sizeOfMatrix; i++ ) {
            for( int j = 0; j < sizeOfMatrix; j++ ) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}