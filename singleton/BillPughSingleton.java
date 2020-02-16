package singleton;

public class BillPughSingleton {

	private BillPughSingleton() {

	}

	/**
	 * When the singleton class is loaded, SingletonHelper class is not loaded
	 * into memory and only when someone calls the getInstance method, this
	 * class gets loaded and creates the Singleton class instance.
	 * 
	 */
	private static class SingletonHelper {
		private static BillPughSingleton instance = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.instance;
	}

	public static void main(String[] args) {
		System.out.println(BillPughSingleton.getInstance());
		System.out.println(BillPughSingleton.getInstance());
	}

}
 