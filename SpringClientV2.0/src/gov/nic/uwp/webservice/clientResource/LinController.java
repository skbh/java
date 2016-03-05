package gov.nic.uwp.webservice.clientResource;

import gov.nic.uwp.webservice.pojo.ErrorMessage;
import gov.nic.uwp.webservice.pojo.InputParameter;
import gov.nic.uwp.webservice.pojo.MultipleLinResponse;
import gov.nic.uwp.webservice.pojo.TestPojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class LinController {
	private static final Logger logger = LoggerFactory
			.getLogger(LinController.class);	
	

	private static List<HttpMessageConverter<?>> getMessageConverters() {//provided converter
		logger.info("HttpMessageConverter Executed");
		/*
		 * Setting MessageConverter for De-serialization
		 */
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJacksonHttpMessageConverter());
		converters.add(new Jaxb2RootElementHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		return converters;
	}//end of method getMessageConverters

	@ModelAttribute
	public void addGenericModelObject(Model modelObject) {/* default Attribute added in Model object*/
		modelObject.addAttribute("HeaderMesageSSDS",
				"Shram Suvidha - Unified Portal for Labour and Employment");
	}//end method addGenericModelObject

	 @ModelAttribute("InputParameter")
	 public InputParameter getInputParameter() {
	  return new InputParameter();
	 }

	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public ModelAndView getLinClientCall(
			@ModelAttribute("InputParameter") InputParameter inputParameter) {/* Request mapping to call LinServer URI*/
		logger.info("getLinClientCall called...");
		System.out.println("inputParameter :" + inputParameter);
		RestTemplate restTemplate = new RestTemplate();//new instance of RestTemplate
		MultipleLinResponse multipleLinResponse = new MultipleLinResponse();//new instance of MultipleLinResponse for De-serialization
		restTemplate.setMessageConverters(getMessageConverters());
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));//setting ContentType
		/* few reference for DE-serial operation */
		ErrorMessage errorMessage = null;
		HttpStatus HttpStatusCode = null;
		HttpEntity<InputParameter> requestEntity = new HttpEntity<InputParameter>(
				inputParameter, requestHeaders);
		try {/*Calling URI to get response acting as a Action*/
			ResponseEntity<MultipleLinResponse> response = restTemplate
					.exchange("http://localhost:8080/SSDS/2.0/webservices/lin",
							HttpMethod.POST, requestEntity,
							MultipleLinResponse.class);
			
			HttpStatusCode = response.getStatusCode();//Getting Status Code from Service
			if (HttpStatusCode != null) //only for testing
				System.out.println("response.getStatusCode() : " + response.getStatusCode());
			
			multipleLinResponse = response.getBody(); //preparing Response Body

			logger.info("view prepared");
		} catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
			Gson gson = new Gson();
			errorMessage = gson.fromJson(e.getResponseBodyAsString(),
					ErrorMessage.class);
			
		}

			if (HttpStatusCode == HttpStatus.BAD_REQUEST
				|| HttpStatusCode == HttpStatus.NOT_FOUND
				|| HttpStatusCode == HttpStatus.LOOP_DETECTED
				|| HttpStatusCode==HttpStatus.NO_CONTENT
				|| HttpStatusCode==HttpStatus.SERVICE_UNAVAILABLE
				|| HttpStatusCode==HttpStatus.UNSUPPORTED_MEDIA_TYPE
				|| HttpStatusCode==HttpStatus.SERVICE_UNAVAILABLE
				|| HttpStatusCode==HttpStatus.INTERNAL_SERVER_ERROR)
			return new ModelAndView("errorHandler", "errorMessage",
					errorMessage);
		else if (HttpStatusCode == HttpStatus.OK || HttpStatusCode == HttpStatus.FOUND)
			return new ModelAndView("viewLin", "multipleLinResponse",
					multipleLinResponse);
		else
			return new ModelAndView("errorHandler", "errorMessage",
					errorMessage);

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getDefaultLin() {
		logger.info("getLin called...");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(getMessageConverters());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(new MediaType("application", "json"));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<TestPojo> response = restTemplate.exchange(
				"http://localhost:8080/SSDS/2.0/webservices/lin", HttpMethod.GET,
				entity, TestPojo.class);
		TestPojo testPojo = response.getBody();
		System.out.println("key :" + testPojo.getKey());
		System.out.println("Value :" + testPojo.getValue());
		logger.info("view prepared");
		return new ModelAndView("viewdefLin", "testPojo", testPojo);

	}

}
