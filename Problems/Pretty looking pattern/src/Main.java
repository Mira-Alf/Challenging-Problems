import java.util.*;

public class Main {
    private static boolean isValidColor(char c) {
        switch(c) {
            case 'W':
            case 'B':
            case 'R':
            case 'G':
            case 'Y':
                return true;
            default:
                return false;
        }
    }

    private static boolean doesMatrixContainValidColors( char[][] characterMatrix ) {
        for( char[] characters : characterMatrix ) {
            for( char c : characters ) {
                if( !isValidColor(c) )
                    return false;
            }
        }
        return true;
    }

    private static void printMatrixBeingChecked( char[][] characterMatrix, MatrixItem[] matrixItems ) {
        int count = 1;
        for( MatrixItem item : matrixItems ) {
            System.out.printf("%c\t", characterMatrix[item.getRowIndex()][item.getColIndex()]);
            if(count%2 == 0)
                System.out.println();
            count++;
        }
        System.out.println("---------------------");
    }

    private static boolean doesMatrixContainSameColor( char[][] characterMatrix, MatrixItem[] matrixItems ) {
        char colorOfItem = '\u0000';
//        printMatrixBeingChecked(characterMatrix, matrixItems);
        for( MatrixItem item : matrixItems ) {
            char c = characterMatrix[item.getRowIndex()][item.getColIndex()];
            if( colorOfItem == '\u0000' )
                colorOfItem = c;
            else {
                if( c != colorOfItem )
                    return false;
            }
        }
        return true;
    }

    private static MatrixItem[] getCornerMatrixItems( MatrixItem item ) {
        int rowIndex = item.getRowIndex(), colIndex = item.getColIndex();
        int newRowIndex = rowIndex == 1 ? rowIndex-1 : rowIndex+1;
        int newColIndex = colIndex == 1 ? colIndex-1 : colIndex+1;
        MatrixItem[] items = { item, new MatrixItem(rowIndex, newColIndex),
                new MatrixItem(newRowIndex, colIndex),
                new MatrixItem(newRowIndex, newColIndex) };
        return items;
    }

    private static boolean isThereACornerMatrixOfSameColor( char[][] characterMatrix ) {
        MatrixItem[] squareMatrix;
        for( MatrixItem item : MatrixItem.matrixItems ) {
            int rowIndex = item.getRowIndex();
            int colIndex = item.getColIndex();
            squareMatrix = getCornerMatrixItems(item);
            //System.out.println("Checking corner matrix "+Arrays.toString(squareMatrix));
            if( doesMatrixContainSameColor(characterMatrix, squareMatrix) )
                return true;
        }
        return false;
    }

    private static MatrixItem[] getSharedMatrixItems( MatrixItem[] items ) {
        MatrixItem[] newItems;
        boolean isRowSame = items[0].getRowIndex() == items[1].getRowIndex();
        boolean isColSame = items[0].getColIndex() == items[1].getColIndex();
        int rowIndex = items[0].getRowIndex();
        int colIndex = items[0].getColIndex();
        if( isRowSame ) {
            int newRowIndex = rowIndex == 1 ? rowIndex-1 : rowIndex+1;
            newItems = new MatrixItem[] { items[0], items[1],
                    new MatrixItem(newRowIndex,items[0].getColIndex()),
                    new MatrixItem(newRowIndex, items[1].getColIndex())};
        } else if( isColSame ) {
            int newColIndex = colIndex == 1 ? colIndex-1 : colIndex+1;
            newItems = new MatrixItem[] { items[0], items[1],
                    new MatrixItem(items[0].getRowIndex(), newColIndex),
                    new MatrixItem( items[1].getRowIndex(), newColIndex)};
        } else {
            newItems = null;
        }
        return newItems;
    }

    private static boolean isThereASharedMatrixOfSameColor( char[][] characterMatrix ) {
        MatrixItem[] squareMatrix;
        for(MatrixItem item : MatrixItem.matrixItems) {
            int rowIndex = item.getRowIndex(), colIndex = item.getColIndex();
            if( rowIndex == colIndex ) {
                    squareMatrix = rowIndex == 1 ?
                            getSharedMatrixItems(new MatrixItem[]{item, new MatrixItem(rowIndex, colIndex+1) }) :
                            getSharedMatrixItems( new MatrixItem[]{ item, new MatrixItem(rowIndex, colIndex-1) } );
            } else {
                squareMatrix = rowIndex == 1 ?
                        getSharedMatrixItems(new MatrixItem[]{ item, new MatrixItem( rowIndex+1, colIndex ) }) :
                        getSharedMatrixItems(new MatrixItem[]{item, new MatrixItem(rowIndex-1,colIndex)});
            }
            //System.out.println("Checking shared matrix "+Arrays.toString(squareMatrix));
            if(doesMatrixContainSameColor(characterMatrix, squareMatrix))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] characterMatrix = new char[4][4];
        Scanner scanner = new Scanner(System.in);
        for( int i = 0; i < 4; i++ ) {
            characterMatrix[i] = scanner.nextLine().toUpperCase().toCharArray();
        }
        boolean lookingPretty = doesMatrixContainValidColors(characterMatrix);
        //System.out.println("Checking core matrix for "+Arrays.toString(MatrixItem.matrixItems));
        lookingPretty = lookingPretty && !doesMatrixContainSameColor(characterMatrix, MatrixItem.matrixItems);
        lookingPretty = lookingPretty && !isThereACornerMatrixOfSameColor(characterMatrix);
        lookingPretty = lookingPretty && !isThereASharedMatrixOfSameColor(characterMatrix);
        System.out.println(lookingPretty ? "YES" : "NO");
    }
}
enum Letter {
    W('W'), B('B'), R('R'), G('G'), Y('Y');
    private char c;

    Letter(char c) {
        this.c = c;
    }
}
class MatrixItem {

    public static final MatrixItem[] matrixItems = { new MatrixItem(1,1),
            new MatrixItem(1,2), new MatrixItem(2,1),
            new MatrixItem(2,2) };
    int rowIndex;
    int colIndex;

    public MatrixItem( int rowIndex, int colIndex ) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public int getColIndex() {
        return this.colIndex;
    }

    public String toString() {
        return String.format("( %d, %d )", getRowIndex(), getColIndex() );
    }
}