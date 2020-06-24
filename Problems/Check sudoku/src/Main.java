import java.util.*;

public class Main {

    public static int sudokuN;
    public static int squareN;

    private static void populateMap(Map<Integer,Integer> map, int key) {
        if(!map.containsKey(key))
            map.put(key,1);
        else
            map.put(key, map.get(key)+1);
    }
    private static boolean isThisValidSudoku( int[] numArray ) {
        Map<Integer, Integer> map = new HashMap<>();
        for( int n : numArray )
            populateMap(map,n);
        return isThisValidSudoku(map);
    }

    private static boolean isThisValidSudoku( int[][] matrix ) {
        Map<Integer, Integer> map = new HashMap<>();
        for( int[] row : matrix ) {
            for( int elem : row ) {
                populateMap(map,elem);
            }
        }
        return isThisValidSudoku(map);
    }

    private static boolean isThisValidSudoku( Map<Integer,Integer> map ) {
        for( int i = 1; i < squareN; i++ ) {
            if( !map.containsKey(i) || !(map.get(i) == 1) )
                return false;
        }
        return true;
    }

    public static boolean checkEachRowAndColumnIsValidSudoku( int[][] sudokuMatrix ) {
        int[] sudokuRow = new int[squareN];
        int[] sudokuColumn = new int[squareN];
        boolean isThisValidSudoku = true;

        for( int i = 0; i < squareN; i++ ) {
            for( int j = 0; j < squareN; j++ ) {
                sudokuRow[j] = sudokuMatrix[i][j];
                sudokuColumn[j] = sudokuMatrix[j][i];
            }
            isThisValidSudoku = isThisValidSudoku(sudokuRow) &&
                    isThisValidSudoku(sudokuColumn);
            if( isThisValidSudoku )
                break;
        }
        return isThisValidSudoku;
    }

    public static boolean checkEachNMatrixIsValidSudoku(int[][] sudokuMatrix) {
        int[][] squareMatrix = new int[sudokuN][sudokuN];
        for(int rowCounter = 0; rowCounter < sudokuN; rowCounter++) {
            for (int columnCounter = 0; columnCounter < sudokuN; columnCounter++) {
                for (int i = 0; i < sudokuN; i++) {
                    for (int j = 0; j < sudokuN; j++) {
                        squareMatrix[i][j] = sudokuMatrix[rowCounter * sudokuN + i][columnCounter * sudokuN + j];
                    }
                }
                if( !isThisValidSudoku( squareMatrix ) )
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main.sudokuN = scanner.nextInt();
        Main.squareN = sudokuN * sudokuN;

        int[][] sudokuMatrix = new int[squareN][squareN];
        boolean shouldProceed = true;
        for( int i = 0; i < squareN && shouldProceed; i++ ) {
            for( int j = 0; j < squareN && shouldProceed; j++ ) {
                int num = scanner.nextInt();
                if( num <= 0 || num > squareN ){
                    shouldProceed = false;
                    break;
                }
                sudokuMatrix[i][j] = num;
            }
        }
        shouldProceed = shouldProceed && checkEachRowAndColumnIsValidSudoku(sudokuMatrix);
        shouldProceed = shouldProceed && checkEachNMatrixIsValidSudoku(sudokuMatrix);
        System.out.println( shouldProceed ? "YES" : "NO" );
    }
}