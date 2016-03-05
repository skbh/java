package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericConstraintViolationExceptionMapper.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class GenericConstraintViolationExceptionMapper implements ExceptionMapper<GenericConstraintViolationException> {

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(GenericConstraintViolationException violationException) {
		// TODO Generic Constraint Violation Exception Mapper implementation
		ErrorMessage errorMessage=new ErrorMessage(violationException.getMessage(),WebserviceMessageConstant.ERROR_CONDITION,"it EITHER violates not-null constraint OR DUPLICATE_KEY_VALUE_VIOLATES_UNIQUE_CONSTRAINT");
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

}
