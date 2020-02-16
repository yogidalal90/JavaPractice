package stack;

import java.util.Stack;

/**
 * Given a string, output is its compressed version. A compressed version of a
 * string is another string with all the consecutive occurrences of characters
 * replaced by the character followed by the number of the occurrences. For
 * e.g., if the input string is: "aaabbacdddd", then the output should be:
 * "a3b2a1c1d4".
 * 
 * @author yogitadalal
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		String s = "aaabbacdddd";
		
		compressString(s);
	}

	private static void compressString(String s) {
		Stack<StringCollector> stk = new Stack<>();
		char[] ch = s.toCharArray();

		for (char c : ch) {
			if (!stk.isEmpty()) {
				StringCollector sc = stk.peek();
				int counter = sc.counter;
				if (sc.data == c) {
					stk.pop();
					sc = new StringCollector(c, counter + 1);
					stk.push(sc);
				} else {
					stk.push(new StringCollector(c));
				}
			} else {
			stk.push(new StringCollector(c));
			}
		}
		
		StringBuilder output = new StringBuilder();
		while(!stk.isEmpty()){
			StringCollector sc = stk.pop();
			output = output.append(sc.counter+""+sc.data);
		}
			System.out.print(output.reverse());
	}

}

class StringCollector {
	char data;
	int counter = 0;

	public StringCollector(char ch) {
		this.data = ch;
		this.counter = 1;

	}

	public StringCollector(char ch, int i) {
		this.data = ch;
		this.counter = i;

	}
}
