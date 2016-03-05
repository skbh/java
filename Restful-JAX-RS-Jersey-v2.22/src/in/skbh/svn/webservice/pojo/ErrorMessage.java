/*
 * @Software Engineer Sushil Kumar Bhaskar
 * @Author SKBH
 * @Version SSDSV2.0
 * @Since Jun 25, 2015
 * @FileName ErrorMessage.java
 * @ProjectName SSDSV2.0
 */
package in.skbh.svn.webservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorMessage.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage {
	
	/** The error messsage. */
	private String errorMesssage;
	
	/** The error code. */
	private int errorCode;
	
	/** The Error info. */
	private String errorInfo;
	
	/**
	 * Instantiates a new error message.
	 */
	public ErrorMessage() { }

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

	/**
	 * Instantiates a new error message.
	 *
	 * @param errorMesssage the error messsage
	 * @param errorCode the error code
	 * @param errorInfo the error info
	 */
	public ErrorMessage(String errorMesssage, int errorCode, String errorInfo) {
		super();
		this.errorMesssage = errorMesssage;
		this.errorCode = errorCode;
		this.errorInfo = errorInfo;
	}

	
		
}
