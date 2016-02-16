package com.skbh.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.skbh.dao.EmpDao;
import com.skbh.model.Employee;

public class EmpAction extends ActionSupport implements ModelDriven<Employee>,Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Employee emp;
	List<Employee> emps;
	private String message;
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	
	
	@Override
	public Employee getModel() {
			return emp;
	}

	@Override
	public void prepare() throws Exception {
		emp=new Employee();
		message = "";
	    emps = new ArrayList<Employee>();
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String excute(){
		System.out.println("excute method called");
		setMessage("excute method called");
		System.out.println(message);
		return SUCCESS;
	}
	
	public String save(){
		System.out.println("excute method called");
		message=new EmpDao().addEmp(emp);
		System.out.println(message);
		return SUCCESS;
	}

	public String delete(){
		System.out.println("excute delete method called");
		message=new EmpDao().deleteEmp(emp);
		System.out.println(message);
		return SUCCESS;
	}
	
	 // update method
	  public String update() {
	    // message = "update method executed";
	    message = new EmpDao().updateEmp(emp);
	    return SUCCESS;
	  }

	  // query method
	  public String query() {
	    message = "query method executed";
	    Employee emp2 = new EmpDao().queryEmp(emp);
	    emps.add(emp2);
	    return SUCCESS;
	  }

	  // showall method
	  public String showall() {
	    message = "All Employees from database";
	    emps = new EmpDao().showallEmp();
	    System.out.println(emps);
	    return SUCCESS;
	  }

	
}
