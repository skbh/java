package in.skbh.svn.webservice.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ebiz.webservice_resource_access_log")
public class WebserviceResourceAccessLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_access_id")
	private Integer resourceAccessId;
	
	@Column(name="uri")
	private String uri;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="method_name")
	private String methodName;
	
	@Column(name="resource_access_time")
	private Date resourceAccessTime;
	
	@Column(name="resource_last_accessed_time")
	private Date resourceLastAccessedTime;
	
	@Column(name="is_secure")
	private Boolean isSecure;
	
	@Column(name="is_async_started")
	private Boolean isAsyncStarted;
	
	@Column(name="is_requested_session_id_valid")
	private Boolean isRequestedSessionIdValid;
	
	@Column(name="max_inactive_interval")
	private Integer maxInactiveInterval;
	
	@Column(name="response_status_code")
	private Integer responseStatusCode;
	
	@Column(name="response_status_info")
	private String responseStatusInfo;
	
	@Column(name="response_class_name")
	private String responseClassName;

	public WebserviceResourceAccessLog() {
		
	}

	public Integer getResourceAccessId() {
		return resourceAccessId;
	}

	public void setResourceAccessId(Integer resourceAccessId) {
		this.resourceAccessId = resourceAccessId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getResourceAccessTime() {
		return resourceAccessTime;
	}

	public void setResourceAccessTime(Date resourceAccessTime) {
		this.resourceAccessTime = resourceAccessTime;
	}

	public Date getResourceLastAccessedTime() {
		return resourceLastAccessedTime;
	}

	public void setResourceLastAccessedTime(Date resourceLastAccessedTime) {
		this.resourceLastAccessedTime = resourceLastAccessedTime;
	}

	public Boolean getIsSecure() {
		return isSecure;
	}

	public void setIsSecure(Boolean isSecure) {
		this.isSecure = isSecure;
	}

	public Boolean getIsAsyncStarted() {
		return isAsyncStarted;
	}

	public void setIsAsyncStarted(Boolean isAsyncStarted) {
		this.isAsyncStarted = isAsyncStarted;
	}

	public Boolean getIsRequestedSessionIdValid() {
		return isRequestedSessionIdValid;
	}

	public void setIsRequestedSessionIdValid(Boolean isRequestedSessionIdValid) {
		this.isRequestedSessionIdValid = isRequestedSessionIdValid;
	}

	public Integer getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	public void setMaxInactiveInterval(Integer maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}

	public Integer getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(Integer responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public String getResponseStatusInfo() {
		return responseStatusInfo;
	}

	public void setResponseStatusInfo(String responseStatusInfo) {
		this.responseStatusInfo = responseStatusInfo;
	}

	public String getResponseClassName() {
		return responseClassName;
	}

	public void setResponseClassName(String responseClassName) {
		this.responseClassName = responseClassName;
	}
	
	
	
	
}
