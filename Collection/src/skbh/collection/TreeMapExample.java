package skbh.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<Integer,String> times=new TreeMap<Integer,String> (); //TreeMap Object creation
		times.put(1200, "Train to New Delhi");//Adding key and value to map
		times.put(1210, "Train to Gurgaon");//Adding key and value to map
		times.put(1300, "Train to New Delhi");//Adding key and value to map
		times.put(1400, "Train to Chennai");//Adding key and value to map
		times.put(1500, "Train to Banglore");//Adding key and value to map
		times.put(1600, "Train to Mumbai");//Adding key and value to map
		times.put(1700, "Train to New Delhi");//Adding key and value to map
		times.put(1710, "Train to New Delhi");//Adding key and value to map
		times.put(1780,"Train to New Delhi");//Adding key and value to map
		
		SortedMap<Integer, String> submap;//Creating SortedMap Reference subMap conversion
		submap=times.subMap(1300, 1700);// from to range selection subMap( from_inclusive, to_exclusive]) 
		System.out.println(submap); //printing SortedMap Data
		submap.put(1645, "train to Chennai");//putting value to subMap
		System.out.println(submap); //printing SortedMap Data
		
		System.out.println("#################################################################");
		System.out.println(times);//printing SortedMap Data
		System.out.println(times.higherKey(1300)); //getting printing higher value next to 1300 [>1300, will return first value]
		System.out.println(times.lowerKey(1300));//getting printing lower value previous to 1300 [<1300, will return first value]
		System.out.println(times.descendingMap());//Reversing TreeMap,by default TreeMap is ordered and sorted[Natural Order]
		//Iterator in map with the help of collection
		Collection<String> c=times.values();
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//end of Iterator
		System.out.println(times.containsKey(1800));//searching existence of key 1800 in TreeMap
		System.out.println(times.containsValue("Train to New Delhi"));//searching existence of value Train to New Delhi in TreeMap
		
		TreeMap<Integer,String> add=new TreeMap<Integer,String>(); //New TreeMap object
		add.putAll(times);//coping data to another TreeMap
		System.out.println(add);//printing copied Data
		submap.put(1445, "train to Kolkata"); // if you add data in SubMap it automatically updates to Parent TreeMap 
		System.out.println(times);//See Demonstration
		System.out.println(submap);//See Demonstration
		
		
	}

}
