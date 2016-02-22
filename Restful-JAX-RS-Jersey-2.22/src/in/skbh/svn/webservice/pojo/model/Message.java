package in.skbh.svn.webservice.pojo.model;

public class Message {
	
	private String statusCode;
	private String statusMessage;
	private String eBizRreferenceNumber;
	private String eBizApplicationID;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String geteBizRreferenceNumber() {
		return eBizRreferenceNumber;
	}
	public void seteBizRreferenceNumber(String eBizRreferenceNumber) {
		this.eBizRreferenceNumber = eBizRreferenceNumber;
	}
	public String geteBizApplicationID() {
		return eBizApplicationID;
	}
	public void seteBizApplicationID(String eBizApplicationID) {
		this.eBizApplicationID = eBizApplicationID;
	}
	
	@Override
	public String toString() {
		return "Message [statusCode=" + statusCode + ", statusMessage="
				+ statusMessage + ", eBizRreferenceNumber="
				+ eBizRreferenceNumber + ", eBizApplicationID="
				+ eBizApplicationID + "]";
	}
	

}
