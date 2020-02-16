package dp;

/**
 * Print the possible combinations for 4 queens a 4*4 array.
 */
public class FourQueens {
	
	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		for(int i=0;i<arr.length;i++){
			if(placeQ(arr,0,i)){
				printArr(arr);
		    }
			resetArr(arr);
		}
	}
	
	private static void printArr(int[][] arr){
		for(int l=0;l<arr.length;l++){
			for(int k=0;k<arr.length;k++){
				System.out.print(arr[l][k]+ " ");
			}
			System.out.println();
		}
	}


	private static void resetArr(int[][] arr){
		for(int l=0;l<arr.length;l++){
			for(int k=0;k<arr.length;k++){
				arr[l][k]=0;
			}
			System.out.println();
		}
	}

	private static boolean placeQ(int[][] arr, int r, int col){
		
		if(r==arr.length)
			return true;
		for(int j=col;j<arr.length;j++){
			if(isSafe(arr,r,j))
			{
				arr[r][j]=1;
				if(placeQ(arr,r+1,0))
					return true;
				arr[r][j]=0;
		}
		}
		return false;
	}


	private static boolean isSafe(int[][] arr, int x,int y){
		int n=arr.length;
		if(arr[x][y] == 1)
			return false;
		for(int i=0;i<n;i++){
			if(arr[i][y]==1)
				return false;
		}
		
		int i,j;
		for(i=0 , j=0; i<=x && j<n;i++, j++){
			if(arr[i][j] == 1)
				return false;
		}		

		for(i=x,j=y;i>=0 && j<n;i--,j++){
			if(arr[i][j] == 1)
				return false;
		}
		return true;
		
	}

}
