package in.skbh.svn.webservice.pojo.clcupload;

public class ReferenceParameters {

	private String eBizReferenceNumber;
	private String eBizReferenceDate;
	private String fileStatus;
	private String eBizApplicationID;

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

	@Override
	public String toString() {
		return "ReferenceParameters [eBizReferenceNumber="
				+ eBizReferenceNumber + ", eBizReferenceDate="
				+ eBizReferenceDate + ", fileStatus=" + fileStatus
				+ ", eBizApplicationID=" + eBizApplicationID + "]";
	}

}
