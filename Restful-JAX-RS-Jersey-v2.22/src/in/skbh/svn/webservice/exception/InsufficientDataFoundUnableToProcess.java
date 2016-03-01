package in.skbh.svn.webservice.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InsufficientDataFoundUnableToProcess.
 */
@net.bull.javamelody.MonitoredWithSpring
public class InsufficientDataFoundUnableToProcess extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new insufficient data found unable to process.
	 *
	 * @param messsge the messsge
	 */
	public InsufficientDataFoundUnableToProcess(String messsge){
		super(messsge);
	}
}
