package array;

//find product of all element excluding ith(current) element
public class ProductExceptIth {

	public static void main(String[] args) {
		int[] a = {10,3,5,6,2};
		findProdExceptIthEle(a);
	}

	private static void findProdExceptIthEle(int[] a){
		int prod = 1;
		for(int i:a){
			prod = prod*i;
		}
		for(int i:a){
			System.out.print(prod/i+" ");
		}
	}
}
