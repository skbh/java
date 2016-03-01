package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class UserAuthenticationExceptionMapper.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class UserAuthenticationExceptionMapper  implements WebserviceMessageConstant, ExceptionMapper<UserAuthenticationException>{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(UserAuthenticationException invalid) {
		ErrorMessage errorMessage=new ErrorMessage(invalid.getMessage(),WebserviceMessageConstant.UNAUTHORISED_ACCESS,"Authentication failed, Authentication was not successful");
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

}
