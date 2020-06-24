import java.util.Scanner;

class Main {

    public static int[][] getInputArray(String inputLine) {
        String[] inputLineTokens = inputLine.split("\n");
        int[][] inputArray = new int[inputLineTokens.length][];
        for( int i = 0; i < inputArray.length; i++ ) {
            String[] numberTokens = inputLineTokens[i].split("\\s+");
            inputArray[i] = new int[numberTokens.length];
            for( int j = 0; j < numberTokens.length; j++ ) {
                inputArray[i][j] = Integer.valueOf(numberTokens[j]);
            }
        }
        return inputArray;
    }

    public static int getElementFromArray( int[][] inputArray, int row, int col ) {
        return inputArray[row][col];
    }

    public static int getSumOfNeighbors( int[][] inputArray, int i, int j ) {
        int[][] neighbors = new int[4][];
        int sumOfNeighbors = 0;
        neighbors[0] = i-1 < 0 ? new int[]{ inputArray.length-1, j } : new int[] {i-1,j};
        neighbors[1] = i+1 == inputArray.length ? new int[] { 0,j } : new int[] { i+1, j };
        neighbors[2] = j-1 < 0 ? new int[] {i, inputArray[i].length-1 } : new int[] { i, j-1 };
        neighbors[3] = j+1 == inputArray[i].length ? new int[] { i, 0 } : new int[] { i, j+1 };
        //System.out.printf("For value at (%d, %d), the neighbors are:%n", i, j);
        for( int counter = 0; counter < 4; counter++ ) {
            int[] neighborsRow = neighbors[counter];
            //System.out.printf("(%d,%d)%n", neighborsRow[0], neighborsRow[1]);
            sumOfNeighbors += getElementFromArray(inputArray, neighborsRow[0], neighborsRow[1] );
        }
        return sumOfNeighbors;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "", input = "";
        do {
            input = scanner.nextLine();
            if( !input.equals("end"))
                inputLine += input + "\n";
        } while(!input.toLowerCase().equals("end") );
        int[][] inputArray;
        if( inputLine.length() > 1 )
            inputArray = getInputArray(inputLine);
        else
            inputArray = new int[][]{{Integer.valueOf(inputLine)}};
        int[][] resultArray = new int[inputArray.length][];
        for( int i = 0; i < inputArray.length; i++ ) {
            resultArray[i] = new int[inputArray[i].length];
            for( int j = 0; j < inputArray[i].length; j++ ) {
                resultArray[i][j] = getSumOfNeighbors(inputArray, i, j);
                System.out.print(resultArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}