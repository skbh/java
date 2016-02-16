package skbh.collection;

import java.util.TreeSet;

public class TreeSetExample {

	
	public static void main(String[] args) {

		TreeSet<Integer> times=new TreeSet<Integer>();
		times.add(1200);		times.add(1215);		times.add(1210);		times.add(1350);		times.add(1300);
		times.add(1520);		times.add(1600);		times.add(1630);		times.add(1625);		times.add(1125);
		System.out.println(times);
		System.out.println("next train After: " + times.higher(1600));
		System.out.println("previous train  before : " + times.higher(1300));
		System.out.println("train leaves at & before : " + times.floor(1600));
		System.out.println("train leaves at & after : " + times.ceiling(1300));
		System.out.println("size of HashMap : " + times.size());		
		System.out.println("Retrieving and removing first Item : " + times.pollFirst());
		System.out.println("Retrieving and removing Last Item : " + times.pollLast());
		System.out.println(times);
		System.out.println(times.descendingSet());
	}

}
