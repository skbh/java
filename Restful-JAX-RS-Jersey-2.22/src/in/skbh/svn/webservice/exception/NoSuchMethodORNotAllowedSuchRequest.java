
package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;
import in.skbh.svn.webservice.service.message.RetrieveMessageFromDBRefWebserviceMessageClass;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


// TODO: Auto-generated Javadoc
/**//**
 * The Class NoSuchMethodORNotAllowedSuchRequest.
 *//*
*/
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class NoSuchMethodORNotAllowedSuchRequest extends
		RetrieveMessageFromDBRefWebserviceMessageClass implements
		WebserviceMessageConstant, ExceptionMapper<WebApplicationException> {
	
	
	/* The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;



	 
	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)*/
	 
	@Override
	public Response toResponse(WebApplicationException notAllowed) {
		if (notAllowed.getResponse().getStatus() == 404) {
			ErrorMessage errorMessage = new ErrorMessage(
					retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.RECORD_NOT_FOUND),
					WebserviceMessageConstant.RECORD_NOT_FOUND,"The requested resource is not available");
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity(errorMessage)
					.type("application/json")
					.build();
		} else if (notAllowed.getResponse().getStatus() == 405) {
			ErrorMessage errorMessage = new ErrorMessage(
					retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER),
					WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER,"METHOD_NOT_ALLOWED");
			return Response.status(Status.METHOD_NOT_ALLOWED)
					.entity(errorMessage)
					.type("application/json")
					.build();
		} else if (notAllowed.getResponse().getStatus() == 406) {
			ErrorMessage errorMessage = new ErrorMessage(
					retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER),
					WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER,"REQUESTED_RANGE_NOT_SATISFIABLE");
			return Response.status(Status.REQUESTED_RANGE_NOT_SATISFIABLE)
					.entity(errorMessage)
					.type("application/json")
					.build();
		} else if (notAllowed.getResponse().getStatus() == 400) {
			ErrorMessage errorMessage = new ErrorMessage(
					retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER),
					WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER,"BAD_REQUEST");
			return Response.status(Status.BAD_REQUEST)
					.entity(errorMessage)
					.type("application/json")
					.build();

		} else if (notAllowed.getResponse().getStatus() == 501) {
			ErrorMessage errorMessage = new ErrorMessage(
					retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.RECORD_NOT_FOUND),
					WebserviceMessageConstant.RECORD_NOT_FOUND,"NOT_IMPLEMENTED_SUCH_RESOURCE");
			return Response.status(Status.NOT_IMPLEMENTED)
					.entity(errorMessage)
					.type("application/json")
					.build();

		}

		ErrorMessage errorMessage = new ErrorMessage(
				retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.ERROR_CONDITION),
				WebserviceMessageConstant.ERROR_CONDITION,"INTERNAL_SERVER_ERROR");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

}
