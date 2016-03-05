package gov.nic.uwp.webservice.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMesssage;
	private int errorCode;
	private String errorInfo;
	
	public ErrorMessage() { }

	
	public ErrorMessage(String errorMesssage, int errorCode, String errorInfo) {
		
		this.errorMesssage = errorMesssage;
		this.errorCode = errorCode;
		this.errorInfo = errorInfo;
	}


	public String getErrorMesssage() {
		return errorMesssage;
	}

	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
		
}
