package gov.nic.uwp.webservice.pojo;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleLinResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty
	@XmlElement
	private LinMessage message;
	@JsonProperty
	@XmlElement
	private List<Lin> linNumbers;

	public MultipleLinResponse() {
	}

	public LinMessage getMessage() {
		return message;
	}

	public void setMessage(LinMessage message) {
		this.message = message;
	}

	public List<Lin> getLinNumbers() {
		return linNumbers;
	}

	public void setLinNumbers(List<Lin> linNumbers) {
		this.linNumbers = linNumbers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MultipleLinResponse [message=" + message + ", linNumbers="
				+ linNumbers + "]";
	}

}
