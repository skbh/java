/**
 * 
 */
package gov.nic.uwp.webservice.pojo;

import java.io.Serializable;

public class InputParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String referenceNumber;
	private String officeAcronym;
	private String referenceDate;
	private String identifierAcronym;
	private String identifier;
	private String userId;
	private String userPassword;

	public InputParameter() {
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getOfficeAcronym() {
		return officeAcronym;
	}

	public void setOfficeAcronym(String officeAcronym) {
		this.officeAcronym = officeAcronym;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getIdentifierAcronym() {
		return identifierAcronym;
	}

	public void setIdentifierAcronym(String identifierAcronym) {
		this.identifierAcronym = identifierAcronym;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InputParameter [referenceNumber=" + referenceNumber
				+ ", officeAcronym=" + officeAcronym + ", referenceDate="
				+ referenceDate + ", identifierAcronym=" + identifierAcronym
				+ ", identifier=" + identifier + ", userId=" + userId
				+ ", userPassword=" + userPassword + "]";
	}

	
	
}
