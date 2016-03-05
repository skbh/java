package in.skbh.svn.webservice.interfaces;

import java.io.Serializable;

/**
 * @author AKHTAR
 * Web Services Constant
 *
 */
public interface WebserviceMessageConstant extends Serializable {

	//TODO: For Response Status
	public static final int SUCCESS = 1001;
	public static final int UNAUTHORISED_ACCESS = 4001;
	public static final int RECORD_NOT_FOUND = 3001;
	public static final int ERROR_CONDITION = 9001;
	public static final int MANDATORY_PARAMETER_REQUIRED = 5001;
	public static final int LIN_NOT_FOUND = 2001;
	public static final int PARAMETER_INVALID_IDENTIFIER = 7001;
	public static final int UNSUPPORTED_XML_FORMAT= 7001;
	public static final int INVALID_XML_PARAMETER=8001;


	//TODO: For Repersenting EA Identifiers
	public static final String EPFO_EA_IDENTIFIER = "EPFO-REGN";
	public static final String ESIC_EA_IDENTIFIER = "ESIC-REGN";
	public static final String IT_EA_IDENTIFIER = "PAN";
	public static final String DGMS_EA_IDENTIFIER = "DGMS-MINE";

	// For Webservice Form
	public static final String LIN_REGISTRATION_FORM = "LIN-REGN";
	public static final String USER_REGISTRATION_FORM = "USER-REGN";
	public static final String WEBSERVICE_FORM = "WEBSERVICE-FORM";
	
}
