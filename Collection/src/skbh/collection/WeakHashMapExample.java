package skbh.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) {
		Map weakHashMap = new WeakHashMap();
		Integer number = new Integer(200);
		weakHashMap.put("sushilKey", "sushil");
		weakHashMap.put(new String("tempObject"), "temp value");
		weakHashMap.put(number, "two hundred");
		weakHashMap.put(new Float(256.00), "temp float value");
		System.out.println("Before Garbage Collector# " + weakHashMap);
		System.gc();
		System.out.println("After Garbage Collector# " + weakHashMap);

	}

}
