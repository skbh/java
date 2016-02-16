package skbh.collection;


import java.util.ArrayList;
import java.util.Collections;

public class ExampleArrayList {

	public static void main(String[] args) {
		ArrayList<String> mylist=new ArrayList<String>();
		String s1="skbh.in";
		String s2="www";
		String s3=".";
		mylist.add("java");
		mylist.add("skbh");
		mylist.add("c++");
		mylist.add("C#");
		mylist.add("javascript");
				
		mylist.add(s2+s3+s1);
		System.out.println("List #" + mylist);
		System.out.println("Size of ArrayList #" + mylist.size()); // find the size of list means ArrayList
		System.out.println("Does it contain #" + mylist.contains("www"));
		System.out.println("get by index no " + mylist.get(1)); // get by index no
		mylist.add(1,"sushil");
		mylist.remove("java");
		System.out.println("size after deletion # " + mylist.size());
		System.out.println("List after operation #" + mylist); // to get all list
		
		Collections.sort(mylist);  //Sort an arrayList
		System.out.println("after sort List #" + mylist);
		Collections.reverse(mylist);		//reverse the list
		System.out.println("after reverse List #" + mylist);
		mylist.remove("skbh");
		System.out.println("size of the list #" + mylist.size());
		System.out.println("new list #" + mylist);
		
		}

}
