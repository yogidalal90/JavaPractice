package array;

/**
 * Rotate only the diagonal of an array.
 */
public class RotateDiagonal {

	public static void main(String[] args) {
		int dimension = 4;
		int[][] arr = generateArray(dimension);

		System.out.println("Before Rotation");
		printArray(arr);

		System.out.println("After Rotation");
		printRotatedArray(arr);

	}

	private static void printRotatedArray(int[][] arr){
		int n = arr.length-1;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(i==j && i<arr.length/2){
					arr[i][j]=arr[i][j]^arr[n-i][n-j];
					arr[n-i][n-j]=arr[i][j]^arr[n-i][n-j];
					arr[i][j]=arr[i][j]^arr[n-i][n-j];

				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void printArray(int[][] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] generateArray(int n){
		int[][] arr = new int[4][4];
		int a=1;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = a++;
			}
		}
		return arr;
	}
}
