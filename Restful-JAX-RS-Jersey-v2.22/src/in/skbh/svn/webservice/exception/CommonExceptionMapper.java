
 
package in.skbh.svn.webservice.exception;
import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;
import in.skbh.svn.webservice.service.message.RetrieveMessageFromDBRefWebserviceMessageClass;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


// TODO: Auto-generated Javadoc
/*The Class CommonExceptionMapper.*/

@Provider
@net.bull.javamelody.MonitoredWithSpring
public class CommonExceptionMapper extends RetrieveMessageFromDBRefWebserviceMessageClass implements ExceptionMapper<Throwable>{

	 
	@Override
	public Response toResponse(Throwable common) {
		ErrorMessage errorMessage=new ErrorMessage(retrieveMessageFromRefWebserviceMessage(WebserviceMessageConstant.ERROR_CONDITION),WebserviceMessageConstant.ERROR_CONDITION,"INTERNAL_SERVER_ERROR");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.type("application/json")
				.build();
	}		

}
		