package singleton;

public class LazyLoadingSingleton {
	public static void main(String[] args) {
		System.out.println(LazyLoading.getInstance());
		System.out.println(LazyLoading.getInstance());
	}
}

class LazyLoading {
	
	private LazyLoading(){
		
	}
	
	private static LazyLoading instance;
	
	public static LazyLoading getInstance(){
		if(instance ==null){
			instance =  new LazyLoading();
		}
		return instance;
	}

	
}