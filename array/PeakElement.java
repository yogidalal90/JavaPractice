package array;

/**
 * A Peak element(ith) is the one, which has (i-1)th and (i+1)th elements greater ith.
 */
public class PeakElement {

	public static void main(String[] args) {
		int[]  a = {11,12,3,4,51,23,55,9};
		if(a == null || a.length ==0){
			System.out.println("Invalid input");
		}
		findPeak(a);
	}
	

	private static void findPeak(int[] a){
		if(a.length == 1){
			System.out.println(a[0]);
		}
		for(int i=0;i<a.length;i++){
			if(i==0 && a[i]<a[i+1]){
				System.out.println(a[i]);
			}
			else if((i == a.length-1) && (a[i-1]>a[i])) {
				System.out.println(a[i]);
			}
			else if (a[i-1]>a[i] && a[i]<a[i+1]){
					System.out.println(a[i]);
			}

		}
	}

}
