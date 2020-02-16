package stack;

import java.util.Stack;

/**
 * Given a string containing parentheses and other characters and a number n, 
 * output the position (index) of the closing parenthesis corresponding to the nth opening parenthesis.
 *  In case the parentheses are unbalanced, output -1
 * @author yogitadalal
 *
 */
public class PrintParanthese {

	public static void main(String[] args) {
		PrintParanthese p = new PrintParanthese();
		p.checkIndex(3);
	}
	
	void checkIndex(int count){
		if(count <= 0){
			System.out.println("no combinations possible");
			return;
		}
		Stack<String> stk = new Stack<>();
		int curr = 1;
		createParanthese(count,curr,stk);
		
	}
	
	void createParanthese(int count, int curr,Stack<String> stk ){
		Stack<String> finalStk = new Stack<>();
		if(count < curr){
			while(!stk.isEmpty()){
				System.out.println(stk.pop());
				
			}
			return;
		}
		if(curr == 1){
			stk.push("()");
			createParanthese(count,curr+1,stk);
		}
		else{
			while(!stk.isEmpty()){
				combination(finalStk,stk.pop());
				
			}
			String x;
			while (!finalStk.isEmpty())  
			{
				
				x = finalStk.pop();
				stk.push(x);
			}
			createParanthese(count,curr+1,stk);
		}
	}
	
	void combination(Stack<String> stk, String s){
		if(s==null){
			return;
		}
		else{
			stk.push("("+s+")");
			stk.push("()"+s);
		}
	}
	
}
