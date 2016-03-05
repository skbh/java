package in.skbh.svn.webservice.exception;

import in.skbh.svn.webservice.interfaces.WebserviceMessageConstant;
import in.skbh.svn.webservice.pojo.model.ErrorMessage;
import in.skbh.svn.webservice.service.message.RetrieveMessageFromDBRefWebserviceMessageClass;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@Provider
public class UnrecognizedPropertyExceptionMapper extends RetrieveMessageFromDBRefWebserviceMessageClass implements 
WebserviceMessageConstant, ExceptionMapper<UnrecognizedPropertyException>
{

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
    public Response toResponse(UnrecognizedPropertyException exception)
    {
    	ErrorMessage errorMessage = new ErrorMessage("'" + exception.getUnrecognizedPropertyName() + "' is an unrecognized field.",
				WebserviceMessageConstant.PARAMETER_INVALID_IDENTIFIER,"BAD_REQUEST");
    	
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .type( MediaType.APPLICATION_JSON)
                .build();
    }

}