package test.valid.skbh;

import com.opensymphony.xwork2.ActionSupport;

public class Valid extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String name;

	
	public String execute(){
		if(getName().equalsIgnoreCase("sushil")){
			return SUCCESS;	
		}
		return LOGIN;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
