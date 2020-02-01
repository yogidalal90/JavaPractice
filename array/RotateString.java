package array;

import java.util.ArrayList;

/**
 * Rotate a string by the number of times specified
 */
public class RotateString {
	public static void main(String[] args) {
		String input = "abcde";
		int rotations = 5;
		stringRotations(input,rotations);
	}

	private static void stringRotations(String s, int rotations) {
		if(s == null || (s != null && s.trim().isEmpty())){
			System.out.println("Invalid input");
			return;
		}
		ArrayList<String> arr= new ArrayList<>();
		arr.add(s.trim());

		for(int i=1;i<=rotations;i++){
			s =  rotateString(arr.get(i-1));
			arr.add(s);
		}
		System.out.println(arr);
	}

	private static String rotateString( String s){
		char[] ch = s.toCharArray();
		char old=ch[0];
		ch[0]=ch[ch.length-1];
		char current;
		for(int i=1;i<ch.length;i++){
			current = ch[i];
			ch[i] = old;
			old = current;
		}
		return String.valueOf(ch);
	}
	
	
}
