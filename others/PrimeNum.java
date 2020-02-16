package others;

/**
 * Find all the prime numbers come before a specified number.
 */
public class PrimeNum {

	public static void main(String[] args) {

		PrimeNum.findPrimeNumer(29);
	}
	private static void findPrimeNumer(int n){
		boolean[] arr =new boolean[n+1];
		
		for(int i=0;i<n+1;i++){
			arr[i] = true;
		}
		
		for(int i=2;i*i<= n;i++){
			if(arr[i] == true){
				for(int j=2;i*j<=n;j++){
					arr[i*j] = false;
				}
			}
		}
		
		for(int i=0;i<n+1;i++){
			if(arr[i] == true){
			System.out.println(i);
			}
		}
		

	}
}
