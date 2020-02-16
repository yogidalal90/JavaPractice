package singleton;

public class DoubleLockingSingleton {
	public static void main(String[] args) {
		System.out.println(ThreadSafeSyncLoading.getInstance());
		System.out.println(ThreadSafeSyncLoading.getInstance());
	}

}

class ThreadSafeSyncLoading {

	private ThreadSafeSyncLoading() {

	}

	private static volatile ThreadSafeSyncLoading instance;

	public static ThreadSafeSyncLoading getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSyncLoading.class) {
				if (instance == null) {
					instance = new ThreadSafeSyncLoading();
				}
			}
		}
		return instance;
	}

}