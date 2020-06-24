import java.util.*;

public class Main {
    public static boolean isVowel( char c ) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }

    private static char[] getThreeCharCheckArray( char[] charArray, char[] threeCharCheckArray, int index ) {
        if( threeCharCheckArray == null )
            threeCharCheckArray = new char[3];
        threeCharCheckArray[0] = charArray[index];
        threeCharCheckArray[1] = '\u0000';
        threeCharCheckArray[2] = '\u0000';
        return threeCharCheckArray;
    }

    private static boolean doesNextCharMaintainSequence(boolean isVowelConsecutive, char nextChar) {
        return (isVowelConsecutive && isVowel(nextChar) ) ||
                (!isVowelConsecutive && !isVowel(nextChar));
    }

    public static void getConsecutiveVowelsOrConsonants(char[] charArray) {
        boolean isVowelConsecutive = isVowel(charArray[0]);
        int insertsCount = 0, stringIndex = 1;

        char[] threeCharCheckArray = getThreeCharCheckArray(charArray,
                null,0);
        int threeCharCheckArrayCount = 1;
        while( stringIndex < charArray.length ) {
            char currentCharacter = charArray[stringIndex];
            boolean doesNextCharMaintainSequence =
                    doesNextCharMaintainSequence(isVowelConsecutive, currentCharacter );
            if( doesNextCharMaintainSequence && threeCharCheckArrayCount < 2 ) {
                threeCharCheckArray[threeCharCheckArrayCount] = charArray[stringIndex];
                threeCharCheckArrayCount++;
            } else if( threeCharCheckArrayCount == 2 || !doesNextCharMaintainSequence ) {
                if( threeCharCheckArrayCount == 2 && doesNextCharMaintainSequence )
                    insertsCount++;
                getThreeCharCheckArray(charArray, threeCharCheckArray, stringIndex);
                isVowelConsecutive = isVowel(charArray[stringIndex]);
                threeCharCheckArrayCount = 1;
            }
            stringIndex++;
        }
        System.out.println(insertsCount);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.next().toCharArray();
        getConsecutiveVowelsOrConsonants(charArray);
    }
}