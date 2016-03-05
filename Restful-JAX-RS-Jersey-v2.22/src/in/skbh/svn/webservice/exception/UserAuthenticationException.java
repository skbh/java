package in.skbh.svn.webservice.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidInputParameters.
 */
@net.bull.javamelody.MonitoredWithSpring
public class UserAuthenticationException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid input parameters.
	 *
	 * @param errorMessage the error message
	 */
	public UserAuthenticationException(String errorMessage){
		super(errorMessage);
	}

}
