package searching;

public class FindMissingRepeating {
    public static void main(String[] args) {
        int[] arr = {1,0,1,2,3,4,5};
        findMissingAndRepeating(arr);
    }
   static  void findMissingAndRepeating(int[] arr) {
       int n = arr.length;
       int i = 0;
       int num = 0;
       for (int a : arr) {
           int temp = i ^ a;
           num = num ^ temp;
           i++;
       }
// 3^4: 011^100 = 111
       int diff = num & (~(num - 1));
       int xorNum = 0;
       for (int j = 0; j < arr.length; j++) {
           if ((j & diff) != 0) {
               xorNum ^= j;
           }
           if ((arr[j] & diff) != 0)
               xorNum ^= arr[j];
       }
       for (int a : arr) {
           if (a == xorNum) {
               System.out.println(xorNum);
               System.out.println(num ^ xorNum);
               break;
           }

       }
   }
}
