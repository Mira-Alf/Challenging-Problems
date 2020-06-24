import java.util.Scanner;

class Main {
    public static boolean ignoreIndex(int totalLength, int index) {
        if(totalLength%2 != 0) {
            if( index == totalLength/2 )
                return true;
        } else {
            int middleIndex = totalLength/2;
            if( index == middleIndex || index == middleIndex-1 )
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.next().toCharArray();
        StringBuilder builder = new StringBuilder();
        for( int i=0; i < charArray.length; i++ ) {
            if( !ignoreIndex(charArray.length,i) )
                builder.append(charArray[i]);
        }
        System.out.println(builder.toString());
    }
}