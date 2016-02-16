package com.skbh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

	private static final long serialVersionUID = -8776555757296461868L;
	protected String empName = "non";
	protected String empId = "52non";
	private volatile Integer Id;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

}

class Person extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String personId;

	public Person(String personid, String ename, String empid) {
		personId = personid;
		empName = ename;
		empId = empid;

	}

	public String getPersonId() {
		return personId;
	}

}

public class SerializableTest {
	public static void main(String[] args) {
		Person person = new Person("1256", "sushil", "891256");
		Person person2 = new Person("5822", "known", "98566");
		System.out.println(person.getEmpId());
		System.out.println(person.getEmpName());
		System.out.println(person.getPersonId());
		person.setId(999);
		System.out.println(person.getId());
		try {
			FileOutputStream fos = new FileOutputStream("newfile.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
			oos.writeObject(person2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileInputStream fos = new FileInputStream("newfile.ser");
			ObjectInputStream oos = new ObjectInputStream(fos);
			Person person1 = (Person) oos.readObject();
			Person person3 = (Person) oos.readObject();
			System.out.println("person1# " + person1.getEmpId());
			System.out.println("person1# " + person1.getEmpName());
			System.out.println("person1# " + person1.getPersonId());
			System.out.println("person1# " + person.getId());
			System.out.println("person3# " + person3.getEmpId());
			System.out.println("person3# " + person3.getEmpName());
			System.out.println("person3# " + person3.getPersonId());
			System.out.println("person3# " + person.getId());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
