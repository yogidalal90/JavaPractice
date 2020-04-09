package array;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {

        public int maximalSquare(char[][] matrix) {
            int currSq = 0;

            int m = matrix.length;
            if(matrix == null || m<1){
                return 0;
            }
            int n= matrix[0].length;
            if(n<1){
                return 0;
            }
            for(int i=0;i<m;i++){
                if(i+currSq > m){
                    continue;
                }
                for(int j=0;j<n;j++){
                    if(j+currSq > n){
                        continue;
                    }
                    while(((i+currSq+1)<=m) && ((j+currSq+1)<=n) && checkSquqre(matrix, i,j, currSq+1)){
                        currSq+=1;
                    }
                }
            }
            return currSq*currSq;
        }

        boolean checkSquqre(char[][] arr, int m,  int n, int size){
            for(int i=m;i<m+size;i++){

                for(int j=n;j<n+size;j++){
                    if(arr[i][j]=='0'){
                        return false;
                    }
                }
            }
            return true;
        }
    }
