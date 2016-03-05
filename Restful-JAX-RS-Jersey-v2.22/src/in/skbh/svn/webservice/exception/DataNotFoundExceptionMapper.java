package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class DataNotFoundExceptionMapper.
 */
@Provider
@net.bull.javamelody.MonitoredWithSpring
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(DataNotFoundException notFound) {
		ErrorMessage errorMessage=new ErrorMessage(notFound.getMessage(),WebserviceMessageConstant.RECORD_NOT_FOUND,"NOT_FOUND");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}

		

}
