package array;

public class Prefix {

    static int MinimumFlips(String s, int n)
    {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (s.charAt(i) == '1' ? 1 : 0);
        }

        // Initialize prefix arrays to store
        // number of changes required to put
        // 1s at either even or odd position
        int[] oddone = new int[n + 1];
        int[] evenone = new int[n + 1];

        oddone[0] = 0;
        evenone[0] = 0;

        for (int i = 0; i < n; i++) {

            // If i is odd
            if (i % 2 != 0) {

                // Update the oddone
                // and evenone count
                oddone[i + 1]
                        = oddone[i]
                        + (a[i] == 1 ? 1 : 0);
                evenone[i + 1]
                        = evenone[i]
                        + (a[i] == 0 ? 1 : 0);
            }

            // Else i is even
            else {

                // Update the oddone
                // and evenone count
                oddone[i + 1]
                        = oddone[i]
                        + (a[i] == 0 ? 1 : 0);
                evenone[i + 1]
                        = evenone[i]
                        + (a[i] == 1 ? 1 : 0);
            }
        }

        // Initialize minimum flips
        int minimum = Math.min(oddone[n],
                evenone[n]);

        // Check if substring[0, i] is
        // appended at end how many
        // changes will be required
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                minimum = Math.min(minimum,
                        oddone[n]
                                - oddone[i + 1]
                                + evenone[i + 1]);
                minimum = Math.min(minimum,
                        evenone[n]
                                - evenone[i + 1]
                                + oddone[i + 1]);
            }
        }

        // Return minimum flips
        return minimum;
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given String
        String S = "001100";

        // Length of given string
        int n = S.length();

        // Function call
        System.out.print(MinimumFlips(S, n));
    }
}
