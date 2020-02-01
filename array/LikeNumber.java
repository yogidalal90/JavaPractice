package array;

/**
 * E.g. 35
 * Like numbers are the numbers which are either multiple of 35(e.g. 35*8=210) or have '35' as part of the number(e.g. 1235).
 */
public class LikeNumber {
	public static void main(String[] args) {
		int a[] = { 210, 2351, 120, 245, 3456, 357};
		likeDislike(a);
	}
	
	private static void likeDislike(int[] a){
		
		for(int i=0;i<a.length;i++){
			if((a[i]%35==0) || ((a[i]+"").contains("35")))
				System.out.print(" like ");
			else
				System.out.print(" unlike ");
				
		}
	}

}
