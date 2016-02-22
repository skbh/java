package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstraintViolationExceptionMapper.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

/*	@Override
	public Response toResponse(final ConstraintViolationException violationException) {
		// TODO Constraint Violation Exception Mapper implementation
		ValidationError validationError=new ValidationError(violationException.getMessage(), "messageTemplate", "path", "invalidValue");
		return Response.status(Status.BAD_REQUEST)
				.entity(validationError)
				.type("application/json")
				.build();
	}
	*/
	
	
	/* (non-Javadoc)
 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
 */
@Override
	public Response toResponse(final ConstraintViolationException violationException) {
		// TODO Constraint Violation Exception Mapper implementation
		ErrorMessage errorMessage=new ErrorMessage("Required field cannot be left blank or Null!",WebserviceMessageConstant.MANDATORY_PARAMETER_REQUIRED,"it EITHER violates not-null constraint OR UNIQUE_CONSTRAINT");
		return Response.status(Status.BAD_REQUEST)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

}
