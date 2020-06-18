package Map;

/**
 * 299. Bulls and Cows
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess
 * what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess
 * match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number
 * but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive
 * the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
 * and B to indicate the cows.
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B (1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.)
 *
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B" (The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.)
 */
public class BullsAndCows {

    private String getHint(String secret, String guess) {

        if(secret == null || secret.isEmpty())
            return "0A0B";

        int n=secret.length();
        int[] smap = new int[10];
        int[] gmap = new int[10];
        int bulls=0, cows=0;
        for(int i=0;i<n;i++){

            if(secret.charAt(i)==guess.charAt(i))
                bulls++;
            else{
                smap[secret.charAt(i)-'0']++;
                gmap[guess.charAt(i)-'0']++;
            }
        }

        for(int i=0;i<10;i++){
            cows+=Math.min(smap[i],gmap[i]);
        }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        BullsAndCows bnc = new BullsAndCows();
        System.out.println(bnc.getHint("1807","7810"));
    }
}
