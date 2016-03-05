package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@net.bull.javamelody.MonitoredWithSpring
public class InvalidInputParametersMapper  implements WebserviceMessageConstant, ExceptionMapper<InvalidInputParameters>{

	
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)*/
	 
	@Override
	public Response toResponse(InvalidInputParameters invalid) {
		ErrorMessage errorMessage=new ErrorMessage(invalid.getMessage(),WebserviceMessageConstant.RECORD_NOT_FOUND,"Invalid InputParameters,its Not Acceptable");
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

}
