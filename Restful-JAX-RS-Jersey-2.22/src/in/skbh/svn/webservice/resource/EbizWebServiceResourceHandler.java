

package in.skbh.svn.webservice.resource;

import in.skbh.svn.webservice.exception.DataNotFoundException;
import in.skbh.svn.webservice.exception.GenericConstraintViolationException;
import in.skbh.svn.webservice.interfaces.ApplicationConstants;
import in.skbh.svn.webservice.pojo.EBizRegistrationObjectsMapping;
import in.skbh.svn.webservice.pojo.EBizUploadedObjects;
import in.skbh.svn.webservice.pojo.model.EbizInputParameter;
import in.skbh.svn.webservice.pojo.model.EbizInputParameters;
import in.skbh.svn.webservice.pojo.model.Message;
import in.skbh.svn.webservice.pojo.model.ResponseMessage;
import in.skbh.svn.webservice.services.ResourceServiceRequestValidator;
import in.skbh.svn.webservice.services.Impl.EbizUploadServiceImpl;
import in.skbh.svn.webservice.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.io.CharStreams;



// TODO: need to be verified from client [TESTING]
/**
 * The Class UploadWebServiceResourceHandler.
 */
/* @RequestScoped - resource instance per request and for subsequent request */
/* @PerLookup - the resource instance is created every time */
/* @Singleton - only one instance per jax-rs application */
@Path("/webservices")
@RequestScoped
@net.bull.javamelody.MonitoredWithSpring
public class EbizWebServiceResourceHandler implements ApplicationConstants {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EbizWebServiceResourceHandler.class);
	/** The validator instance. */
	@Autowired
	private ResourceServiceRequestValidator validatorInstance;
	
	@Autowired
	private EbizUploadServiceImpl ebizUploadService;

	
	public EbizUploadServiceImpl getEbizUploadService() {
		return ebizUploadService;
	}

	public void setEbizUploadService(EbizUploadServiceImpl ebizUploadService) {
		this.ebizUploadService = ebizUploadService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	/**
	 * Gets the validator instance.
	 *
	 * @return the validator instance
	 */
	public ResourceServiceRequestValidator getValidatorInstance() {
		return validatorInstance;
	}

	/**
	 * Sets the validator instance.
	 *
	 * @param validatorInstance
	 *            the new validator instance
	 */
	public void setValidatorInstance(
			ResourceServiceRequestValidator validatorInstance) {
		this.validatorInstance = validatorInstance;
	}


	
	
	/**
	 * E biz registration receiving service.
	 *
	 * @param ebizInputParameters the ebiz input parameters
	 * @param uriInfo the uri info
	 * @return the response
	 * @throws GenericConstraintViolationException the generic constraint violation exception
	 */
	@POST
	@Path("/ebiz/offlineregistrationdata")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response eBizRegistrationReceivingService(EbizInputParameters ebizInputParameters,@Context UriInfo uriInfo) throws GenericConstraintViolationException {
		/**
		 * Validating input parameters and throw exception directly to client
		 * throw new GenericConstraintViolationException
		 */
		validatorInstance.inspectionActionReportServiceInputParametersValidator(ebizInputParameters);//End validation
		
		EBizRegistrationObjectsMapping eBizRegistrationObjectsMapping=new EBizRegistrationObjectsMapping();
		ResponseMessage responseMessage;
		Message message;
		
		if (logger.isDebugEnabled()) {
			logger.info("...eBizRegistrationReceivingService being executed...");
		}
		/*begin Object preparation to save in database*/
		eBizRegistrationObjectsMapping.seteBizApplicationID(ebizInputParameters.getReferenceParameters().geteBizApplicationID());
		eBizRegistrationObjectsMapping.seteBizReferenceDate(ebizInputParameters.getReferenceParameters().geteBizReferenceDate());
		eBizRegistrationObjectsMapping.seteBizReferenceNumber(ebizInputParameters.getReferenceParameters().geteBizReferenceNumber());
		eBizRegistrationObjectsMapping.setFileStatus(ebizInputParameters.getReferenceParameters().getFileStatus());
		eBizRegistrationObjectsMapping.setXmlContent(ebizInputParameters.getRequestParameters().getXmlFileContent().replaceAll("^=\"$", "").replaceAll("\r\n", ""));
		eBizRegistrationObjectsMapping.setFileName(ebizInputParameters.getRequestParameters().getFileName());
		eBizRegistrationObjectsMapping.setJsonContent(xmlToJsonConvertor(ebizInputParameters.getRequestParameters().getXmlFileContent()));
		eBizRegistrationObjectsMapping.setFileUploadedDateAndTime(new Date());
		/*END Object preparation to save in database*/
		
        
       Integer status=ebizUploadService.saveEBizUploadedObjects(eBizRegistrationObjectsMapping);/*Saving Object into Database*/
       
       if(status!=null){
    	   responseMessage=new ResponseMessage();
    	   message=new Message();
    	   message.setStatusCode("1001");
    	   message.setStatusMessage("Data has been received successfully.");
    	   message.seteBizApplicationID(ebizInputParameters.getReferenceParameters().geteBizApplicationID());
    	   message.seteBizRreferenceNumber(ebizInputParameters.getReferenceParameters().geteBizReferenceNumber());
    	   responseMessage.setMessage(message);
    	   return Response.ok(200).entity(responseMessage).build();
    	   
       }
       else{
    	   responseMessage=new ResponseMessage();
    	   message=new Message();
    	   message.setStatusCode("3001");
    	   message.setStatusMessage("Data receiving failed, provided data not sufficient for upload");
    	   message.seteBizApplicationID(ebizInputParameters.getReferenceParameters().geteBizApplicationID());
    	   message.seteBizRreferenceNumber(ebizInputParameters.getReferenceParameters().geteBizReferenceNumber());
    	   responseMessage.setMessage(message);
    	   return Response.ok(400).entity(responseMessage).build();
       }

	}	
	
	/**
	 * Init report response.
	 *
	 * @param file the file
	 * @param fileDisposition the file disposition
	 * @param inputParameter the input parameter
	 * @param uriInfo  the uri info
	 * @return the response
	 * @throws DataNotFoundException  the data not found exception
	 * @throws IOException 
	 */
	  /*final ResourceConfig resourceConfig = new ResourceConfig(MultiPartFeature.class);		resourceConfig.register(MultiPartFeature.class);
				resourceConfig.register(LoggingFilter.class);*/
	@POST
	@Path("/ebiz/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response eBizUploadService(@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileDisposition,
		    @FormDataParam("inputParameter") FormDataBodyPart  inputParameter,@Context UriInfo uriInfo) throws DataNotFoundException, IOException {
		
		inputParameter.setMediaType(MediaType.APPLICATION_JSON_TYPE);
		EbizInputParameter ebizInputParameter = inputParameter.getValueAs(EbizInputParameter.class);
		EBizUploadedObjects eBizUploadedObjectsInstance=new EBizUploadedObjects();
		ResponseMessage responseMessage;
		Message message;
		String fileName = fileDisposition.getFileName();
		System.out.println("inputParameter : " + ebizInputParameter + "\n" + "uploadedFileLocation :" + fileName);
		
		String extension = null;
		try {
			extension = Util.getFileExtension(fileName);
		} catch (Exception exceptionObject) {
			exceptionObject.printStackTrace();
		}
		System.out.println("extension:" + extension);
		if (!extension.equals("xml")) {
			if (logger.isDebugEnabled()) {
				logger.debug("...eBizUploadService - > Not Acceptable 406  File Upload Failed, Please Upload Xml File Only!...");
			}
		}
		//writeToFile(file, uploadedFileLocation);// save it
		
		String stringFromStream = CharStreams.toString(new InputStreamReader(file, "UTF-8"));
        System.out.println(stringFromStream);
        byte[] byteArray=IOUtils.toByteArray(file);
        System.out.println("byte []" + byteArray);
        eBizUploadedObjectsInstance.setXmlContent(stringFromStream);
        eBizUploadedObjectsInstance.setXmlFile(byteArray);
        eBizUploadedObjectsInstance.seteBizApplicationID(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizApplicationID());
        eBizUploadedObjectsInstance.seteBizReferenceDate(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizReferenceDate());
        eBizUploadedObjectsInstance.seteBizReferenceNumber(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizReferenceNumber());
        eBizUploadedObjectsInstance.setFileStatus(ebizInputParameter.getInputParameter().getReferenceParameter().getFileStatus());
        eBizUploadedObjectsInstance.setFileUploadedDateAndTime(new Date());
        
       Integer status=ebizUploadService.saveEBizUploadedObjects(eBizUploadedObjectsInstance);
       if(status!=null){
    	   responseMessage=new ResponseMessage();
    	   message=new Message();
    	   message.setStatusCode("1001");
    	   message.setStatusMessage("File Has Been Uploaded Successfully.");
    	   message.seteBizApplicationID(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizApplicationID());
    	   message.seteBizRreferenceNumber(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizReferenceNumber());
    	   responseMessage.setMessage(message);
    	   
       }
       else{
    	   responseMessage=new ResponseMessage();
    	   message=new Message();
    	   message.setStatusCode("3001");
    	   message.setStatusMessage("File Upload Failed, Provided data not sufficient for upload");
    	   message.seteBizApplicationID(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizApplicationID());
    	   message.seteBizRreferenceNumber(ebizInputParameter.getInputParameter().getReferenceParameter().geteBizReferenceNumber());
    	   responseMessage.setMessage(message);
       }
    	   


		if (logger.isDebugEnabled()) {
			logger.info("...eBizUploadService being executed...");
		}
		if(status!=null)
		return Response.ok(200).entity(responseMessage).build();
		return Response.ok(400).entity(responseMessage).build();

	}
	

	
	private String xmlToJsonConvertor(String xmlContent) {
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(xmlContent);
			String jsonPrettyPrintString = xmlJSONObj.toString(4);
			return jsonPrettyPrintString;
		} catch (JSONException je) {
			return "Error Info# ".concat(je.toString());
		}

	}


@SuppressWarnings("unused")
private void writeToFile(InputStream uploadedInputStream,String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
}

