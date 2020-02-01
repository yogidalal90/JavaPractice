package array;

/**
 * Find the first non-repeating character in a string
 */
public class FirstNonRepeatedChar
{
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("asdsdfs"));
    }
    public static Character firstNonRepeatedCharacter(String str) {
        if(str==null || str.length()==0) return null;

        int[] charQuantity = new int[256];
        for(char currentCharacter : str.toCharArray()) {
            charQuantity[currentCharacter] += 1;
        }
        for(char currentCharacter : str.toCharArray()) {
            if(charQuantity[currentCharacter]==1) {
                return currentCharacter;
            }
        }
        return null;
    }
}
