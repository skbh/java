package in.skbh.svn.webservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationStatus {

	@XmlElement(name="ApplicationStatus")
	private String applicationStatus;
	@XmlElement(name="DatabaseStatus")
	private String databaseStatus;
	@XmlElement(name="SecureSocketLayerStatusPort8443")
	private String secureSocketLayerStatusPort8443;
	@XmlElement(name="NonSecureSocketLayerStatusPort8080")
	private String nonSecureSocketLayerStatusPort8080;
	@XmlElement(name="UsedHeapSizeMemory")
	private Long usedHeapSizeMemory;
	@XmlElement(name="FreeHeapSizeMemory")
	private Long freeHeapSizeMemory;
	@XmlElement(name="TotalHeapHeapSizeMemory")
	private Long totalHeapHeapSizeMemory;
	@XmlElement(name="MaximumHeapHeapSizeMemory")
	private Long maximumHeapHeapSizeMemory;
	@XmlElement(name="HtmlContent")
	private String htmlContent;
	
	public ApplicationStatus() {
		super();
	}
	
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getDatabaseStatus() {
		return databaseStatus;
	}
	public void setDatabaseStatus(String databaseStatus) {
		this.databaseStatus = databaseStatus;
	}
	public String getSecureSocketLayerStatusPort8443() {
		return secureSocketLayerStatusPort8443;
	}
	public void setSecureSocketLayerStatusPort8443(
			String secureSocketLayerStatusPort8443) {
		this.secureSocketLayerStatusPort8443 = secureSocketLayerStatusPort8443;
	}
	public String getNonSecureSocketLayerStatusPort8080() {
		return nonSecureSocketLayerStatusPort8080;
	}
	public void setNonSecureSocketLayerStatusPort8080(
			String nonSecureSocketLayerStatusPort8080) {
		this.nonSecureSocketLayerStatusPort8080 = nonSecureSocketLayerStatusPort8080;
	}
	public Long getUsedHeapSizeMemory() {
		return usedHeapSizeMemory;
	}
	public void setUsedHeapSizeMemory(Long usedHeapSizeMemory) {
		this.usedHeapSizeMemory = usedHeapSizeMemory;
	}
	public Long getFreeHeapSizeMemory() {
		return freeHeapSizeMemory;
	}
	public void setFreeHeapSizeMemory(Long freeHeapSizeMemory) {
		this.freeHeapSizeMemory = freeHeapSizeMemory;
	}
	public Long getTotalHeapHeapSizeMemory() {
		return totalHeapHeapSizeMemory;
	}
	public void setTotalHeapHeapSizeMemory(Long totalHeapHeapSizeMemory) {
		this.totalHeapHeapSizeMemory = totalHeapHeapSizeMemory;
	}
	public Long getMaximumHeapHeapSizeMemory() {
		return maximumHeapHeapSizeMemory;
	}
	public void setMaximumHeapHeapSizeMemory(Long maximumHeapHeapSizeMemory) {
		this.maximumHeapHeapSizeMemory = maximumHeapHeapSizeMemory;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
	
	
	
	
	
	
}
