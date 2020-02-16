package singleton;

public class StaticEagerLoading {
	
	private StaticEagerLoading(){
		
	}
	
	private static StaticEagerLoading instance;
	
	static{
		try{
			instance =  new StaticEagerLoading();
		} catch(Exception e){
			throw new RuntimeException("exception while creating the instance.");
		}
	}
	
	public StaticEagerLoading getInstance(){
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(StaticEagerLoading.instance);
		System.out.println(StaticEagerLoading.instance);
	}
	
}
