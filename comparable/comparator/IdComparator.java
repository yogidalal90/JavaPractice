package comparable.comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<ComparatorEmployee> {

	
	@Override
	public int compare(ComparatorEmployee c1, ComparatorEmployee c2){
		if(c1.id > c2.id)
			return 1;
		if(c1.id < c2.id)
			return -1;
		else 
			return 0;
	}
}
