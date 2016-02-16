package skbh.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SearchInArray {

	public static void main(String[] args) {
		String[] sa = { "apple", "mango", "Pineapple", "Banana", "Pomegranate" };

		for (String a : sa)
			System.out.print(a + " ");// Printing data from an array

		Arrays.sort(sa, 1, sa.length);// sort in an array[you can user Array.sort(sa) instead of  Arrays.sort(sa, 1, sa.length)]
		System.out.println('\n' + "Result after sort ");
		System.out.println("Your search result:"
				+ Arrays.binarySearch(sa, "mango")); // perform binary search
		for (String a : sa)
			// printing an array
			System.out.print(a + " ");

		List<String> li = Arrays.asList(sa);// converting an array to list
		System.out.println('\n' + "" + li);

		Collections.sort(li);// sorting in collection List
		System.out.println(li);// printing list

		li.set(2, "Pomegranate");
		System.out.println("data at 2 #" + li.get(2));
		Iterator<String> it = li.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}


		// convert it to an array
		Object[] o = li.toArray();
		for (Object a : o)
			System.out.println(" " + (String) a);//printing data from an array

	}

}
