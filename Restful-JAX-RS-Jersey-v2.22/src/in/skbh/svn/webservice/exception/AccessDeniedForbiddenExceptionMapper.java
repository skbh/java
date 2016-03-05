package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessDeniedForbiddenException.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class AccessDeniedForbiddenExceptionMapper implements ExceptionMapper<AccessDeniedForbiddenException>{

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(AccessDeniedForbiddenException Forbidden) {
		ErrorMessage errorMessage=new ErrorMessage(Forbidden.getMessage(),WebserviceMessageConstant.UNAUTHORISED_ACCESS,"You don't have permission to access on this Web Service Server...");
		return Response.status(Status.FORBIDDEN)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

		

}
