package singleton;


public class EagerLoadingSingleton {
	public static void main(String[] args) {
		System.out.println(EagerLoading.getInstance());
		System.out.println(EagerLoading.getInstance());
	}
}

class EagerLoading {
	
	private EagerLoading(){
		
	}
	
	private static EagerLoading instance = new EagerLoading();
	
	public static EagerLoading getInstance(){
		return instance;
	}

	
}