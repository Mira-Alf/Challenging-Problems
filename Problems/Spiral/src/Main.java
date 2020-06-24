import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static int[] getNextPoint( int[] point, int lowerLimit, int upperLimit ) {
        int[] newPoint = new int[2];
        if( point[0] == lowerLimit && point[1] < upperLimit )
            newPoint = new int[] {point[0], point[1]+1};
        else if( (point[0] >= lowerLimit && point[0] < upperLimit) && point[1] == upperLimit )
            newPoint = new int[] { point[0]+1, point[1] };
        else if( point[0] == upperLimit && ( point[1] > lowerLimit && point[1] <= upperLimit ) )
            newPoint = new int[] { point[0], point[1]-1 };
        else if( (point[0] <= upperLimit && point[0] > lowerLimit) && point[1] == lowerLimit )
            newPoint = new int[] { point[0]-1, point[1] };
        return newPoint;
    }

    private static void displayMatrix( int[][] matrix ) {
        for( int[] rows : matrix ) {
            for( int elem : rows ) {
                System.out.print( elem + " " );
            }
            System.out.println();
        }
    }
    private static void setMatrixValue( int[][] matrix, int[] point, int value ) {
        int row = point[0];
        int col = point[1];
        //System.out.printf("Filling (%d,%d) with %d%n", row, col, value );
        matrix[row][col] = value;
    }

    private static int[][] getMatrix( int sizeOfMatrix ) {
        if( sizeOfMatrix > 1 )
            return new int[sizeOfMatrix][sizeOfMatrix];
        else
            return new int[][] { {1} };
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = scanner.nextInt();
        int squareOfSize = sizeOfMatrix*sizeOfMatrix;

        int[][] matrix = getMatrix(sizeOfMatrix);
        int value = 1, lowerLimit = 0, upperLimit = sizeOfMatrix-1;

        while( value <= squareOfSize && sizeOfMatrix > 1 ) {
            int[] startingPoint = {lowerLimit,lowerLimit};
            setMatrixValue( matrix, startingPoint, value);
            value++;
            if( value > squareOfSize )
                break;

            int[] point = {startingPoint[0], startingPoint[1]+1};
            int[] prevPoint = {startingPoint[0], startingPoint[1] };

            while (!(point[0] == startingPoint[0] && point[1] == startingPoint[1])) {
                setMatrixValue(matrix, point, value);
                value++;

                prevPoint = new int[]{point[0], point[1]};
                point = getNextPoint(point, lowerLimit, upperLimit);
                if (value > sizeOfMatrix * sizeOfMatrix)
                   break;
            }
            lowerLimit = prevPoint[0];
            upperLimit = sizeOfMatrix - 1 - lowerLimit;
            if (value > sizeOfMatrix * sizeOfMatrix)
                break;
        }
        displayMatrix(matrix);
    }
}