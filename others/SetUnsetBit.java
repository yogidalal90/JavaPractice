package others;

public class SetUnsetBit {
	
	public static void main(String[] args) {
		//set(1) nth bit
		int x= setBit(5, 3);
		//reset(0) nth bit
		int y = resetBit(x, 3);
		// get the value at nth bit
		int z = getBit(y, 3);
		System.out.println("x: "+x+ "\ny: "+y+"\nz: "+z);
		
	}
	static int setBit(int a, int n){
		int mask = 1<<n;
		
		return a|mask;
		
	}
	
	static int resetBit(int a, int n){
		int mask = 1<<n;
		
		return a&(~mask);
		
	}
	
	static int getBit(int a, int n){
		int mask = 1<<n;
		
		return a&mask;
		
	}
}
