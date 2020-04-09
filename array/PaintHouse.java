package array;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 */
public class PaintHouse {
    public static void main(String[] args) {
        int[][] houses = new int[3][3];
        for(int i=0;i<houses.length;i++){
            for(int j=0;j<houses[0].length;j++){
                houses[i][j]=i+j+2;
            }
        }

        for(int i=0;i<houses.length;i++){
            for(int j=0;j<houses[0].length;j++){
                System.out.print(houses[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(minCostToPaint(houses));
    }

    private static int minCostToPaint(int[][] arr){

        int max1=arr[0][0];
        int max2=arr[0][1];
        int max3 = arr[0][2];
        System.out.println(max1+":"+max2+":"+max3);
        for(int i=1;i<arr.length;i++){
            int curr1 = arr[i][0]+Math.min(max2,max3);
            int curr2 = arr[i][1]+Math.min(max1,max3);
            int curr3 = arr[i][2]+Math.min(max2,max1);

            max1 =curr1; max2= curr2; max3=curr3;
            System.out.println(max1+":"+max2+":"+max3);
        }
        int minCost = Math.min(max1,max2);
        return Math.min(minCost,max3);

    }
}
