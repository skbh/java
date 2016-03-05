/**
 *
 */
package in.skbh.svn.webservice.pojo;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="ebiz.ref_webservice_message")
public class RefWebserviceMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String messages;
	private String short_message;
	private String msg_discription;
	private String message_type;
	
	public RefWebserviceMessage() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getShort_message() {
		return short_message;
	}

	public void setShort_message(String short_message) {
		this.short_message = short_message;
	}

	public String getMsg_discription() {
		return msg_discription;
	}

	public void setMsg_discription(String msg_discription) {
		this.msg_discription = msg_discription;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RefWebserviceMessage [id=" + id + ", messages=" + messages
				+ ", short_message=" + short_message + ", msg_discription="
				+ msg_discription + ", message_type=" + message_type + "]";
	}
	
	
}
