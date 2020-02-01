package array;

import java.util.ArrayList;

/**
 * How many squares (of any size) and rectangles are there on a chess board ?
 * @author yogitadalal
 *
 */
public class SquaresInChess {
	
	public static void main(String[] args) {
		NumberOfSq(2);
	}
	
	static void NumberOfSq(int num){
		
		int squareCount=0;
		int rectangleCount=0;

		squareCount = (num*(num+1)*(2*num+1))/6;
		rectangleCount=((num*(num+1)/2)*(num*(num+1)/2));
		System.out.println("squareCount: "+squareCount+" rec: "+rectangleCount);
	}
}
