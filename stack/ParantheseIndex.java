package stack;

import java.util.Stack;

/**
 * Given a string containing parentheses and other characters and a number n, 
 * output the position (index) of the closing parenthesis corresponding to the nth opening parenthesis.
 *  In case the parentheses are unbalanced, output -1
 * @author yogitadalal
 *
 */
public class ParantheseIndex {

	public static void main(String[] args) {
		ParantheseIndex p = new ParantheseIndex();
		int index = 13;
		p.checkIndex("((sdf(f()fgb)fgb)",index);
	}
	
	void checkIndex(String s, int n){
		if(s == null || s.isEmpty()){
			System.out.println("Not a valid String.");
			return;
		}
		Stack<Character> stk = new Stack<>();
		char[] c = s.toCharArray();
		if( c.length > n){
			System.out.println("Invalid input index.");
			return;
		}
		int index = 0;
		int pushcounter = 0;
		int popcounter = 0;


		for(char ch:c){
			index +=1;
			if(ch == '('){
				stk.push(ch);
				pushcounter +=1;
			}
			else if(ch == ')'){
				stk.pop();
			}
			if(pushcounter == n)
				break;
		}

		int temp = index;
		popcounter = pushcounter;
		for(int i = temp;i<c.length;i++){
			index +=1;
			if(c[i] == '('){
				stk.push(c[i]);
				popcounter +=1;
			}
			else if(c[i] == ')'){
				popcounter -=1;
				stk.pop();
			}

			if(popcounter == pushcounter -1){
				System.out.println(index);
				break;
			}
		}

	}
	
}
