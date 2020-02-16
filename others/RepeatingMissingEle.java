package others;

public class RepeatingMissingEle {
	
	public static void main(String[] args) {
		//Series should be of continuous natural numbers, can not be like {1,2,3,4,7}. it should be {1,2,4,3,6} for n=5
		int[] arr = {3,1,2,4,4}; 		int numbers=5;		repeatedMissingEle(arr,numbers);
	}

	/**
	 *  Only for array with elements starting from 1 to n and with one missing and one repeating element
	 * @param a
	 * @param n
	 * @return
	 */
	private static int repeatedMissingEle(int[] a, int n) {
		int xor = 0;
		int zor = 0;
		int sum = 0;
		
		// save elements upto 5 in b[]
		int[] b = new int[n+1];
		for(int i=1;i<n+1;i++) {
			b[i]= i;
		}
		
		
		//remove same elements
		for(int i=0;i<n;i++){
			xor ^= a[i]^b[i];
			sum += a[i];
		}
		
		int total = n*(n+1)/2;
		int missingEle = total -(sum-xor);
		System.err.println("Missing Element: "+missingEle);
		System.err.println("Repeated Element: "+xor);
		return xor;
		
	}


}

