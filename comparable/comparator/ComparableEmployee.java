package comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEmployee  implements Comparable<ComparableEmployee>{
	
	int id;
	String area;
	
	ComparableEmployee(int id, String area){
		this.id = id;
		this.area=area;
	}
	
	public static void main(String[] args) {
		ComparableEmployee c1 = new ComparableEmployee(0, "ann");
		ComparableEmployee c2 = new ComparableEmployee(1, "vicky");
		ComparableEmployee c3 = new ComparableEmployee(2, "dev");
		ComparableEmployee c4 = new ComparableEmployee(3, "riya");
		ComparableEmployee c5 = new ComparableEmployee(4, "fiza");
		ComparableEmployee c6 = new ComparableEmployee(5, "rina");
		ComparableEmployee c7 = new ComparableEmployee(5, "tarun");
		List<ComparableEmployee> cl = new ArrayList<ComparableEmployee>();
		cl.add(c7);
		cl.add(c5);
		cl.add(c6);
		cl.add(c4);
		cl.add(c3);
		cl.add(c1);
		cl.add(c2);
		 Collections.sort(cl);
		 System.out.println(c1);
		 for(ComparableEmployee c :cl){
			 System.out.println(c.getId()+" "+c.getArea());
		 }
	}

	@Override
	public int compareTo(ComparableEmployee o) {
		if(this.id > o.id){
			return 1;
		}else if(this.id < o.id)
			return -1;
		else{
			return (this.area).compareTo(o.area);
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
