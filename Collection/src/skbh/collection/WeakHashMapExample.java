package skbh.collection;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Constructs a new WeakHashMap with the same mappings as the specified
 * map. The WeakHashMap is created with the default load factor (0.75)
 * and an initial capacity sufficient to hold the mappings in the specified map.
 *
 * @param weakHashMap  the map whose mappings are to be placed in this map
 * @throws NullPointerException if the specified map is null
 * @since 1.3
 */
public class WeakHashMapExample {

	public static void main(String[] args) {
		Map<Object, String> weakHashMap = new WeakHashMap<Object, String>();
		Integer number = new Integer(200);
		weakHashMap.put("sushilKey", "sushil");// Strong reference
		weakHashMap.put(new String("tempObject"), "temp value");// due to weak reference it goes to garbage collector, System.gc()
		weakHashMap.put(number, "two hundred");// Strong reference
		weakHashMap.put(new Float(256.00), "temp float value");// due to weak reference it goes to garbage collector, System.gc()
		System.out.println("Before Garbage Collector# " + weakHashMap);
		System.gc();// called garbage collector
		System.out.println("After Garbage Collector# " + weakHashMap);

	}

}
