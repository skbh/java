package in.skbh.svn.webservice.pojo.model;

public class InputParameter {

	private ReferenceParameter referenceParameter;

	public ReferenceParameter getReferenceParameter() {
		return referenceParameter;
	}

	public void setReferenceParameter(ReferenceParameter referenceParameter) {
		this.referenceParameter = referenceParameter;
	}

	@Override
	public String toString() {
		return "InputParameter [referenceParameter=" + referenceParameter + "]";
	}

}