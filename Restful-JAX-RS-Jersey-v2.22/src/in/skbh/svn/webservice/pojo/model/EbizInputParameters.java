package in.skbh.svn.webservice.pojo.model;

public class EbizInputParameters {

	private ReferenceParameters referenceParameters;
	private RequestParameters requestParameters;

	public ReferenceParameters getReferenceParameters() {
		return referenceParameters;
	}

	public void setReferenceParameters(ReferenceParameters referenceParameters) {
		this.referenceParameters = referenceParameters;
	}

	public RequestParameters getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(RequestParameters requestParameters) {
		this.requestParameters = requestParameters;
	}

	@Override
	public String toString() {
		return "EbizInputParameters [referenceParameters="
				+ referenceParameters + ", requestParameters="
				+ requestParameters + "]";
	}

}
