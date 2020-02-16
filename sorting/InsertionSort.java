package sorting;

/**
 * divide array in two parts, sorted and unsorted. insert elements one by one at correct position.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {11,24,12,167,113,115,12,124};
        array = insertionSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }

    public static int[] insertionSort(int[] arr){
         for(int pass=1;pass < arr.length;pass ++){
             int finalIndex =pass;
                int temp = arr[pass];
                 for(int i=pass-1;i>=0 && arr[i]>temp;i--){
                     arr[i+1]=arr[i];
                     finalIndex =i;
                 }
                 arr[finalIndex] = temp;
             }

        return  arr;
    }
}
