package in.skbh.svn.webservice.services.Impl;

import in.skbh.svn.webservice.exception.GenericConstraintViolationException;
import in.skbh.svn.webservice.interfaces.ApplicationConstants;
import in.skbh.svn.webservice.pojo.model.EbizInputParameters;
import in.skbh.svn.webservice.service.message.RetrieveMessageFromDBRefWebserviceMessageClass;
import in.skbh.svn.webservice.services.ResourceServiceRequestValidator;
import in.skbh.svn.webservice.util.Util;




// TODO: Auto-generated Javadoc
/**
 * The Class ResourceServiceRequestValidatorImpl.
 */
@net.bull.javamelody.MonitoredWithSpring
public class ResourceServiceRequestValidatorImpl 
extends RetrieveMessageFromDBRefWebserviceMessageClass 
implements	ResourceServiceRequestValidator,ApplicationConstants {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void inspectionActionReportServiceInputParametersValidator(EbizInputParameters inputParameters){

		if(inputParameters==null)		
			throw new GenericConstraintViolationException("Invalid Input Parameters, Please Provide Parameters");
				else if(inputParameters.getRequestParameters()==null)
					throw new GenericConstraintViolationException("Invalid Request Parameters, Please Provide Request Parameters");
						else if(inputParameters.getRequestParameters().getFileName()==null || inputParameters.getRequestParameters().getFileName().length()==0)
							throw new GenericConstraintViolationException("file Name is either null or empty, Please Provide file Name field");
								else if(inputParameters.getRequestParameters().getXmlFileContent()==null || inputParameters.getRequestParameters().getXmlFileContent().length()==0)
									throw new GenericConstraintViolationException("file content is either null or empty, Please Provide file content field");
		
		if(inputParameters.getReferenceParameters()==null)
			throw new GenericConstraintViolationException("Invalid Reference Parameters, Please Provide Reference Parameters");
				else if(!Util.isThisDateValid(inputParameters.getReferenceParameters().geteBizReferenceDate(),"dd-MM-yyyy"))
					throw new GenericConstraintViolationException("Invalid Reference Date Under Reference Parameters, Please Provide Reference Date Under Reference Parameters");
						else if(inputParameters.getReferenceParameters().geteBizApplicationID()==null || inputParameters.getReferenceParameters().geteBizApplicationID().length()==0)
							throw new GenericConstraintViolationException("Invalid Application ID Under Reference Parameters, Please Provide ApplicationID Under Reference Parameters");
								else if(inputParameters.getReferenceParameters().geteBizReferenceNumber()==null || inputParameters.getReferenceParameters().geteBizReferenceNumber().length()==0)
									throw new GenericConstraintViolationException("Invalid eBiz Reference Number Under Reference Parameters, Please Provide eBiz Reference Number Under Reference Parameters");
										else if(inputParameters.getReferenceParameters().getFileStatus()==null || inputParameters.getReferenceParameters().getFileStatus().length()==0)
											throw new GenericConstraintViolationException("Invalid File Status Under Reference Parameters, Please Provide File Status Under Reference Parameters");
		
	}





}
