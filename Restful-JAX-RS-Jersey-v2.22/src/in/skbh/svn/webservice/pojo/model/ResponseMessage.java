package in.skbh.svn.webservice.pojo.model;

public class ResponseMessage {
	
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + "]";
	}
	
	

}
