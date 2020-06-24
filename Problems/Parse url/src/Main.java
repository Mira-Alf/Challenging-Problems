import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetURL = scanner.nextLine();
        String parameterString = targetURL.substring(targetURL.indexOf("?")+1);
        String[] parameters = parameterString.split("&");
        String passwordValue = "";
        for( String p : parameters ) {
            String[] keyValue = p.split("=");
            if( keyValue[0].equals("pass") )
                passwordValue = keyValue.length == 1 ? "not found" : keyValue[1];
            System.out.printf("%s : %s%n", keyValue[0],
                    keyValue.length == 1 || keyValue[1].length() == 0 ?
                            "not found" : keyValue[1] );
        }
        if( passwordValue.length() > 0 )
            System.out.printf("password : %s%n", passwordValue);
    }
}