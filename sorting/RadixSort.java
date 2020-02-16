package sorting;

public class RadixSort {

	public static void main(String[] args) {
		int[] a = { 123, 543, 123, 545, 232, 234, 545, 456 };

		int count = findNumOfDigits(a);
		if(count < 0){
			System.out.println("Invalid array input.");
			return;
		}
		System.out.print("Before Sorting: ");
		for (int i = 0; i < a.length; i++) {
			
			System.out.print(a[i]+" ");
		}
		System.out.print("\nAfter Sorting:  ");
		sort(a,count);
	}

	private static void sort(int a[], int rad) {
		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int x = 0;
				int d =1;
				int rem = 10;
				while (x < rad) {
					int jth = (a[j]%rem)/d;
					int ith = (a[i]%rem)/d;
					if (jth < ith) {
						temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
					rem = rem*10;
					d=d*10;
					x++;
				}
			}
			System.out.print(a[i]+" ");
		}
	}
	
	private static int findNumOfDigits(int[] a){
		int max = 0;
		int count = 0;
		if (a.length > 0) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > max) {
					max = a[i];
				}
			}
			while (max != 0) {
				max = max / 10;
				count++;
			}
		} else {
			return -1;
		}
		return count;
	}
}
