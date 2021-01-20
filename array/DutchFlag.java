package array;

public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = {4,6,2,6,31,4,6,3,5};
        arr = updateArr(arr,1);
        for(int i:arr)
            System.out.print(i+" ");
    }
    static int[] updateArr(int[] arr, int x){
        if(arr == null || arr.length <2 || x >= arr.length)
            return arr;
        int large = arr.length-1;
        int small = 0;
        int equal=0;
        int ele = arr[x];
        while(equal<=large){
            if(arr[equal] < ele)
               swap(arr,small++,equal++);
            else if(arr[equal] == ele)
                equal++;
            else{
                swap(arr,equal++,large--);
            }
        }

        return arr;

    }
    static int[] swap(int[] arr, int start, int end){
        int temp = arr[end];
        arr[end] =  arr[start];
        arr[start] = temp;
        return arr;
    }

}
