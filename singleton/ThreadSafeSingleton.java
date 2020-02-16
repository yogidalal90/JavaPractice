package singleton;

public class ThreadSafeSingleton {
	public static void main(String[] args) {
		System.out.println(ThreadSafeLoading.getInstance());
		System.out.println(ThreadSafeLoading.getInstance());
	}

}

class ThreadSafeLoading {
	
	private ThreadSafeLoading(){
		
	}
	
	private static ThreadSafeLoading instance;
	
	public static synchronized ThreadSafeLoading getInstance(){
			
		if(instance ==null){
			instance =  new ThreadSafeLoading();
		}
		return instance;
	}

	
}