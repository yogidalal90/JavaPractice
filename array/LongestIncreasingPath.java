package array;

/**
 * 329. Longest Increasing Path in a Matrix
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Input: nums = [[9,9,4], [6,6,8], [2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LongestIncreasingPath path = new LongestIncreasingPath();
        System.out.println(path.longestIncreasingPath(matrix));
    }
    private int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        if(n<1)
            return 0;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int length = findPath(matrix, i, j, cache, Long.MAX_VALUE);
                max = Math.max(max,length);
            }
        }
        return max;
    }

    private int findPath(int[][] matrix, int i, int j, int[][] cache, long pre){
        int n = matrix.length;  int m = matrix[0].length;
        if(i<0 || i>n-1 || j<0 || j> m-1 || matrix[i][j] >= pre) return 0;
        if(cache[i][j] > 0 ) return cache[i][j];
        else{
            int tempMax = 0;
            tempMax = Math.max(findPath(matrix,i-1,j,cache,matrix[i][j]),tempMax);
            tempMax = Math.max(findPath(matrix,i+1,j,cache,matrix[i][j]),tempMax);
            tempMax = Math.max(findPath(matrix,i,j-1,cache,matrix[i][j]),tempMax);
            tempMax = Math.max(findPath(matrix,i,j+1,cache,matrix[i][j]),tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
