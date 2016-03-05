package in.skbh.svn.webservice.util;

import java.io.Serializable;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * Used in list to show simple drop down list with id and values
 */
public class SelectOption implements Serializable, JSONAware {

	private static final long serialVersionUID = 1490870459542566700L;
	private String key;
	private String value;

	public SelectOption() {

		super();
	}

	public SelectOption(String key, String value) {

		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toJSONString() {

		JSONObject obj = new JSONObject();

		obj.put("key", key);
		obj.put("value", value);

		return obj.toString();
	}
}
