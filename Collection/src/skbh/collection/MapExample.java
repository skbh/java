package skbh.collection;

import java.util.HashMap;
import java.util.Map;

class Cat { }
enum Data{	One,	two,	three,	Four,	Five }

class Animal{
	String code;
	String Name;
	
	public Animal(String code,String Name){
		this.code=code;
		this.Name=Name;
	}
	
	public int hashCode(){
		return Name.length();
	}
	
}
/*HashMap & Hashtable are both are unordred and unsorted,HashMap allows one null key and multiple null value
 * Hash Map is not thread safe but Hashtable is thread safe,Hashtable doesn't allow anything null;
 * 
*/
public class MapExample {

		public static void main(String[] args) {
		Map<Object,Object> m=new HashMap<Object,Object>(); 
		m.put("type 1", new Animal("new bread","vodafone dog"));
		m.put("type 3", Data.three);
		m.put(Data.two, "Key as Value");
		Animal a=new Animal("unknown","find him");
		m.put(a, "404 key");
		m.put(new Cat(), "Cat Object");
		m.put(12345, "Cat Object");
		m.put(null,null);
		
		
		System.out.println(m.get("type 1"));
		System.out.println(m.get(Data.two));
		System.out.println(m.get(a));
		System.out.println(m.get(new Cat()));
		System.out.println(m.size());
		System.out.println(m.get("type 3"));
		System.out.println(m);
		System.out.println(m.get(12345));
		System.out.println();//type syso & then hit [ ctrl + space ] It will automatically convert to System.out.println() [AUTO-COMPLETE]
		
		
		
		
	}

}
