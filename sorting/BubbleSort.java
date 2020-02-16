package sorting;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements
 * if they are in wrong order
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,4,12,67,113,115,123,124};
         arr = bubbleSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static int[] bubbleSort(int[] arr){

        if(arr == null && arr.length == 0 ){
            return arr;
        }
        // Add swap to process array in inner loop only if array is not sorted.
        boolean swap=false;

        //1,4,12,67,113,115,123,24
        for(int pass=0;pass<arr.length-1;pass++){
            System.out.println("pass: "+pass);
                for(int i=0;i<arr.length-1;i++){
                    if(arr[i]>arr[i+1]){
                        swap = true;
                        int temp=arr[i];
                        arr[i]=arr[i+1];
                        arr[i+1]=temp;
                    }
                }
            if(!swap){
                return arr;
            }
        }
        return arr;
    }
}