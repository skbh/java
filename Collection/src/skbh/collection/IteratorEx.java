package skbh.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Gsort implements Comparator<Human>{// for sorting collection
		@Override
	public int compare(Human o1, Human o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class Human{ //object to be saved in list
	int age;
	String name;
	
	public Human(int age,String name){
		this.age=age;
		this.name=name;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode(){
		return age;
		
	}
}

public class IteratorEx {//Main method
	
	public static void search(List<Human> woman,String search){
		
		Iterator<Human> iti=woman.iterator();
			while(iti.hasNext()){
			Human w=(Human) iti.next();
			if(w.getName().contains(search))
			System.out.println("Name #[" + w.name + "] " + "Age #[" + w.age+ "]");
						
		}
		}
	
	
public static void search(List<Human> woman,int age){
		
		Iterator<Human> iti=woman.iterator();
			while(iti.hasNext()){
			Human w=(Human) iti.next();
			if(w.getAge()==age)
			System.out.println("Name #[" + w.name + "] " + "Age #[" + w.age+ "]");
						
		}
		}
	
	public static void main(String[] args) {
		List<Human> man=new ArrayList<Human>();// List 1
		Human h1=new Human(25,"sushil kumar bhaskar");
		man.add(h1); // Adding data to list
		man.add(new Human(25,"singh Sahab"));// Adding data to list
		man.add(new Human(35,"Bimlesh kumar"));// Adding data to list
		man.add(new Human(60,"J N Singh"));// Adding data to list
		Human h2=new Human(36,"Ramesh Kumar");// Adding data to list
		
		man.add(h2);// Adding data to list
		Gsort gs=new Gsort();
		Collections.sort(man,gs);
		Iterator<Human> it=man.iterator();
		while(it.hasNext()){
			Human h=it.next();
			System.out.println("Name #[" + h.name + "] " + "Age #[" + h.age+ "]");
		}
		
		List<Human> woman=new ArrayList<Human>();// List 2
		woman.add(new Human(25,"to be find"));// Adding data to list
		woman.add(new Human(55,"S M DEVI "));// Adding data to list
		woman.add(new Human(40,"S M DEVI "));// Adding data to list
		woman.add(new Human(40,"S DEVI "));// Adding data to list
		Gsort gsw=new Gsort();//creating object for compare
		Collections.sort(woman,gsw); //using comparator to sort 
		
		Iterator<Human> nit=woman.iterator();
		while(nit.hasNext()){
			Human w=(Human) nit.next();
			System.out.println("Name #[" + w.name + "] " + "Age #[" + w.age+ "]");
						
		}
		System.out.println("size (man object )#" + man.size());
		System.out.println("size (woman object )#" + woman.size());
		
		System.out.println("searching objects");
		search(woman,"to be find");
		search(man,25);
		Collections.reverse(woman);//reverse the list
		System.out.println(woman);
	

	}

}
