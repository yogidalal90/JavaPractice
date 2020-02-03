package comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorEmployee  {
	
	int id;
	String area;
	
	ComparatorEmployee(int id, String area){
		this.id = id;
		this.area=area;
	}
	
	public static void main(String[] args) {
		ComparatorEmployee c1 = new ComparatorEmployee(0, "ann");
		ComparatorEmployee c2 = new ComparatorEmployee(1, "vicky");
		ComparatorEmployee c3 = new ComparatorEmployee(2, "dev");
		ComparatorEmployee c4 = new ComparatorEmployee(3, "riya");
		ComparatorEmployee c5 = new ComparatorEmployee(4, "fiza");
		ComparatorEmployee c6 = new ComparatorEmployee(5, "rina");
		ComparatorEmployee c7 = new ComparatorEmployee(5, "tarun");
		List<ComparatorEmployee> cl = new ArrayList<ComparatorEmployee>();
		cl.add(c7);
		cl.add(c5);
		cl.add(c6);
		cl.add(c4);
		cl.add(c3);
		cl.add(c1);
		cl.add(c2);    
		 Collections.sort(cl, new IdComparator());
		 System.out.println(c1);
		 for(ComparatorEmployee c :cl){
			 System.out.println(c.getId()+" "+c.getArea());
		 }
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	

}
