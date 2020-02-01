package array;

/**
 * Returns true, if all characters in the input string is non-repeating.
 */
public class AllCharUnique {
    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique("inputChars"));
    }

    private static boolean areAllCharactersUnique(String str){

        if(str == null || str.length() <= 1) return true;
        // 2^8 = 256. Covers all characters in ASCII.
        boolean[] checker_array = new boolean[256];

        for(int i=0;i<str.length();i++){
            int position = str.charAt(i);
            if(checker_array[position]) return false;
            checker_array[position] = true;
        }
        return true;
    }
}
