package in.skbh.svn.webservice.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ebiz.ebiz_uploaded_objects")
public class EBizUploadedObjects {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ebiz_request_upload_Id")
	private Integer ebizRequestUploadedId;
	
	@Column(name="xml_file")
	private  byte[] xmlFile;
	
	@Column(name="xml_content")
	private String xmlContent;
	
	@Column(name="ebiz_reference_number")
	private String eBizReferenceNumber;
	
	@Column(name="ebiz_reference_date")
	private String eBizReferenceDate;
	
	@Column(name="file_status")
	private String fileStatus;
	
	@Column(name="ebiz_application_id")
	private String eBizApplicationID;
	
	@Column(name="file_uploaded_date_and_time")
	private Date fileUploadedDateAndTime;
	
	

	public Date getFileUploadedDateAndTime() {
		return fileUploadedDateAndTime;
	}


	public void setFileUploadedDateAndTime(Date fileUploadedDateAndTime) {
		this.fileUploadedDateAndTime = fileUploadedDateAndTime;
	}


	public EBizUploadedObjects() {
		
	}

	
	public String geteBizReferenceNumber() {
		return eBizReferenceNumber;
	}


	public void seteBizReferenceNumber(String eBizReferenceNumber) {
		this.eBizReferenceNumber = eBizReferenceNumber;
	}


	public String geteBizReferenceDate() {
		return eBizReferenceDate;
	}


	public void seteBizReferenceDate(String eBizReferenceDate) {
		this.eBizReferenceDate = eBizReferenceDate;
	}


	public String getFileStatus() {
		return fileStatus;
	}


	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}


	public String geteBizApplicationID() {
		return eBizApplicationID;
	}


	public void seteBizApplicationID(String eBizApplicationID) {
		this.eBizApplicationID = eBizApplicationID;
	}


	public Integer getEbizRequestUploadedId() {
		return ebizRequestUploadedId;
	}

	public void setEbizRequestUploadedId(Integer ebizRequestUploadedId) {
		this.ebizRequestUploadedId = ebizRequestUploadedId;
	}


	public byte[] getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(byte[] xmlFile) {
		this.xmlFile = xmlFile;
	}

	public String getXmlContent() {
		return xmlContent;
	}

	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}
	
	
	
	
}
