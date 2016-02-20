package skbh.collection;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>(); // unordered and unsorted[can add both string and number etc]
		boolean[] b = new boolean[7];
		b[0] = set.add("sushil");
		b[1] = set.add(122546);
		b[2] = set.add(new Object());
		b[3] = set.add(new Integer(999));
		b[4] = set.add("bhaskar");
		b[5] = set.add("bhaskar");
		b[6] = set.add("kumar");
		for (int x = 0; x < b.length; x++) {
			System.out.print(b[x] + " ");
		}
		System.out.print('\n');
		for (Object o : set) {
			System.out.print(o + " ");
		}
		System.out.print('\n');
		System.out.println(set);
	}

}
