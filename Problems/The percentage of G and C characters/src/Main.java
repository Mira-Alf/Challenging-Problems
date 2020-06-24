import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String genomeSeq = scanner.next().toLowerCase();

        double gcCount = 0.0;
        for( char c : genomeSeq.toCharArray() ) {
            if( c == 'c' || c == 'g' )
                gcCount++;
        }
        gcCount = gcCount/genomeSeq.length() * 100.0;
        System.out.println(gcCount);

    }
}