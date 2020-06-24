import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static final char[][] ALLOWED_CHARS;
    public static final int UPPERCASE_GROUP = 0;
    public static final int LOWERCASE_GROUP = 1;
    public static final int NUMBER_GROUP = 2;
    public static final int SYMBOL_GROUP = 3;
    public static final char[] SYMBOLS = {'$', '#', '@', '!', '%', '^', '&', '*' };
    public static int[] includeGroups;

    static {
        char c = 'a', n = '0';
        char[] upperCaseLetters = new char[26];
        char[] lowerCaseLetters = new char[26];
        char[] numbers = new char[10];
        for( int i = 0; i < 26; i++ ) {
            upperCaseLetters[i] = Character.toUpperCase(c);
            lowerCaseLetters[i] = c;
            if( i < 10 ) {
                numbers[i] = n;
                n++;
            }
            c++;
        }
        ALLOWED_CHARS = new char[3][];
        ALLOWED_CHARS[UPPERCASE_GROUP] = upperCaseLetters;
        ALLOWED_CHARS[LOWERCASE_GROUP] = lowerCaseLetters;
        ALLOWED_CHARS[NUMBER_GROUP] = numbers;
    }

    public static int[] REQUIRED_SYMBOLS = new int[3];
    public static int NOT_EXCEED_LENGTH;

    private static int getRandom( int factor) {
        return (int)(Math.random() * factor);
    }

    private static char[] getGroup() {
        int randomGroupNumber = getRandom(3);
        return getGroup(randomGroupNumber);
    }

    private static char[] getGroup(int groupNumber) {
        return ALLOWED_CHARS[groupNumber];
    }

    public static void setInitGroups() {
        String includeGroupsText = "";
        for( int i = 0; i < 3; i++ ) {
            if( REQUIRED_SYMBOLS[i] > 0 )
                includeGroupsText += i + ",";
        }
        includeGroups = null;
        if( includeGroupsText.length() > 0 ) {
            includeGroupsText = includeGroupsText.substring(0, includeGroupsText.length()-1);
            includeGroups = new int[ includeGroupsText.split(",").length];
            int count = 0;
            for( String group : includeGroupsText.split(",") ) {
                includeGroups[count] = Integer.valueOf(group);
            }
        }
        //System.out.println(">>"+Arrays.toString(includeGroups));
    }

    private static char getRandomElement( ) {
        char[] group;
        if( includeGroups == null ) {
            group = SYMBOLS;
        } else {
            int random = getRandom(includeGroups.length);
            int groupNumber = includeGroups[random];
            group = getGroup(groupNumber);
        }
        return getRandomElement(group);
    }

    private static char getRandomElement( char[] group ) {
        int index = getRandom(group.length);
        return group[index];
    }

    private static char getRandomElement( int groupNumber ) {
        char[] group = getGroup(groupNumber);
        return getRandomElement(group);
    }

    private static int getARequiredGroup() {
        int group = -1;
        while( group == -1 ) {
            int random = getRandom(3);
            if( REQUIRED_SYMBOLS[random] > 0 )
                group = random;
        }
        return group;
    }

    public static char[][] getSymbolsToUse() {
       char[][] symbolsToUse = new char[3][];
       for( int i = 0; i < 3; i++ ) {
           if( REQUIRED_SYMBOLS[i] > 0 )
                symbolsToUse[i] = new char[REQUIRED_SYMBOLS[i]];
           else
               symbolsToUse[i] = new char[]{'\u0000'};
           for( int j = 0; j < REQUIRED_SYMBOLS[i]; j++ ) {
               symbolsToUse[i][j] = getRandomElement(i);
           }
       }
       return symbolsToUse;
    }

    private static void printSymbolsToUse( char[][] symbolsToUse ) {
        for( char[] array : symbolsToUse ) {
            for( char c : array ) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    public static String generatePassword() {
        char[][] symbolsToUse = getSymbolsToUse();
        //printSymbolsToUse(symbolsToUse);
        StringBuilder builder = new StringBuilder();
        char prevElement = '\u0000';
        int[] limits = {symbolsToUse[0].length, symbolsToUse[1].length, symbolsToUse[2].length};
        int[] counters = {0, 0, 0};
        for( int i = 0; i < limits.length; i++ ) {
            if( symbolsToUse[i].length == 1 && symbolsToUse[i][0] == '\u0000' )
                limits[i] = -1;
        }
        boolean continueMerge = true;
        int index = 0;
        while( continueMerge ) {
            char c;
            if( counters[index] < limits[index] && symbolsToUse[index][counters[index]] != '\u0000' ) {
                c = symbolsToUse[index][counters[index]];
                if( c == prevElement )
                    while( (c = getRandomElement(index)) == prevElement );
                builder.append(c);
                prevElement = c;
                counters[index]++;
            }
            index++;
            if( index == symbolsToUse.length )
                index = 0;
            continueMerge = (counters[0] < limits[0]) || (counters[1] < limits[1]) || (counters[2] < limits[2]);
        }
        //System.out.println(">>here"+builder.toString());
        for( int i = builder.toString().length(); i < NOT_EXCEED_LENGTH; i++ ) {
            char c;
            while( (c = getRandomElement()) == prevElement );
            builder.append(c);
            prevElement = c;
        }
        return builder.toString();
    }

    private static int getTypeOfCharacter( char c ) {
        if( Character.isDigit(c) )
            return NUMBER_GROUP;
        else if( Character.isLowerCase(c) )
            return LOWERCASE_GROUP;
        else if( Character.isUpperCase(c) )
            return UPPERCASE_GROUP;
        return SYMBOL_GROUP;
    }

    private static boolean isValid(String password) {
        if( password.length() == 0 )
            return true;
        if( password.length() != NOT_EXCEED_LENGTH)
            return false;
        int[] numberOfCharacters = {0, 0, 0, 0};
        char prev = password.charAt(0);
        numberOfCharacters[getTypeOfCharacter(prev)]++;

        for( int i = 1; i < password.length(); i++ ) {
            char c = password.charAt(i);
            if( c == prev )
                return false;
            prev = c;
            int typeOfCharacter = getTypeOfCharacter(c);
            numberOfCharacters[typeOfCharacter]++;
        }
        boolean doesNotMeetMinimumRequiredCharacters = numberOfCharacters[UPPERCASE_GROUP] < REQUIRED_SYMBOLS[UPPERCASE_GROUP] ||
                                        numberOfCharacters[LOWERCASE_GROUP] < REQUIRED_SYMBOLS[LOWERCASE_GROUP] ||
                                        numberOfCharacters[NUMBER_GROUP] < REQUIRED_SYMBOLS[NUMBER_GROUP];
        if( doesNotMeetMinimumRequiredCharacters )
            return false;
        return true;
    }

    private static void testMain() {
        REQUIRED_SYMBOLS[0] = 3;
        REQUIRED_SYMBOLS[1] = 2;
        REQUIRED_SYMBOLS[2] = 3;
        NOT_EXCEED_LENGTH = 10;
        while(true) {
            String password = generatePassword();
            System.out.println(password);
            if( !isValid(password) )
                break;
        }
    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        do {
            REQUIRED_SYMBOLS[count] = scanner.nextInt();
            count++;
        } while( count < 3 );
        NOT_EXCEED_LENGTH = scanner.nextInt();
        setInitGroups();
        String password = generatePassword();
        if( isValid(password) )
            System.out.println(password);
        //testMain();
    }


}