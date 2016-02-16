package example.java;

class Test{
	int a;
	public int hashCode(){
		return 789;
	}
	
}

public class HashCode { // creating HashCode class
	int value;
	
	public HashCode(int param){ //constructor
		value=param;
		
	}

	public int hashCode(){ //overriding hashCode()
		return 5553;
	}
	
	 
	  public String toString(){
		return ("value of object;" + value); //it you don't override, it will return hashcode value of an object 
	}	
	
	
	
	public static void main(String[] args) {
		HashCode h=new HashCode(12);//new object of HashCode class
		HashCode i=new HashCode(12);//new object of HashCode class
		HashCode j=new HashCode(15);//new object of HashCode class
		Test t=new Test(); //new object of Test class
	
				
		
		System.out.println("Hascode value of an object:### " + h);	//returns has code if you don't override toString() method	
		System.out.println("Hascode value of an object:### " + i);//returns has code if you don't override toString() method
		System.out.println("Hascode value of an object:### " + j);//returns has code if you don't override toString() method
		System.out.println("Hascode value of an object:### " + t);//returns has code if you don't override toString() method
		
		if(h.hashCode()==i.hashCode())
			System.out.println("h and i is same");
			else
			System.out.println("h and i is  not same");
		
		if(h==i)
			System.out.println("h and i is same");
			else
				System.out.println("h and i is not same");
		
		if(h.equals(i))
			System.out.println("h and i is same");
			else
				System.out.println("h and i is not same");
	}

}
