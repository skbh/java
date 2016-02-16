package string.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
class Calculator{
	
	public int add(int... numbers ){
		int sum=0;
		for(int i: numbers){
			sum+=i;
		}
		return sum; 
	}
	
}

public class TestStringObject {

	@Before
	public void setup(){
		System.out.println("Test stared");
	}
	@After
	public void end(){
		System.out.println("Test end");
	}
	
	@Test
	public void post(){
	System.out.println("success");
	}
	
	@Test
	public void  calladd(){
		Calculator cal=new Calculator();
		System.out.println(cal.add(12,52,63,98,325,65,89));
	}
	
	
	public static void main(String[] args) {
		TestStringObject obj=new TestStringObject();
		obj.post();
		obj.calladd();

	}

}
