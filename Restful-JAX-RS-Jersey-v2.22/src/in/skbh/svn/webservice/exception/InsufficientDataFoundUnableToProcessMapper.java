package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class InsufficientDataFoundUnableToProcessMapper.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class InsufficientDataFoundUnableToProcessMapper implements ExceptionMapper<InsufficientDataFoundUnableToProcess>{

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(InsufficientDataFoundUnableToProcess unableToProcess) {
		ErrorMessage errorMessage=new ErrorMessage(unableToProcess.getMessage(),WebserviceMessageConstant.ERROR_CONDITION,"Insufficient Data Found, Unable To Process Your Request!");
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}
	

}
