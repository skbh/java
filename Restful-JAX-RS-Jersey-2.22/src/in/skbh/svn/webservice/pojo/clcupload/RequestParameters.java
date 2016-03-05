package in.skbh.svn.webservice.pojo.clcupload;

public class RequestParameters {
	private String FileName;
	private String xmlFileContent;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getXmlFileContent() {
		return xmlFileContent;
	}
	public void setXmlFileContent(String xmlFileContent) {
		this.xmlFileContent = xmlFileContent;
	}
	@Override
	public String toString() {
		return "RequestParameters [FileName=" + FileName + ", xmlFileContent="
				+ xmlFileContent + "]";
	}
	

}
