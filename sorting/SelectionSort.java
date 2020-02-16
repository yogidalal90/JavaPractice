package sorting;

/**
 * Select the highest element and swap with last element. (n-i)th element in the end
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1,2,4,12,32,4,3};
  //      array = SelectionSort(array);

        array = sortedArr(array);
        for(int i:array)
            System.out.print(i+"  ");
    }

    public static int[] sortedArr(int[] arr){

        if(arr == null || arr.length == 1){
            return arr;
        }
        for(int pass=0;pass<arr.length;pass++){
            int bigIndex=0;
            for(int i=0;i<arr.length-pass;i++){
                if(arr[i]>arr[bigIndex]){
                    bigIndex = i;
                }
            }

            int temp = arr[bigIndex];
            arr[bigIndex] = arr[arr.length-pass-1];
            arr[arr.length-pass-1] = temp;
        }

        return arr;
    }

    public static int[] SelectionSort(int[] arr){
        if(arr == null){
            return  null;
        }
        for(int pass=0;pass<arr.length;pass++) {
            int maxEleIndex=0;
            for (int i = 0; i < arr.length-pass; i++) {
                if (arr[i] > arr[maxEleIndex]) {
                    maxEleIndex = i;
                }
            }

            int temp=arr[arr.length-pass-1];
            arr[arr.length-pass-1]= arr[maxEleIndex];
            arr[maxEleIndex]=temp;

        }


        return arr;
    }
}
