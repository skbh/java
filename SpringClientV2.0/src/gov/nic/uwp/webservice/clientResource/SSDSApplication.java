package gov.nic.uwp.webservice.clientResource;


import gov.nic.uwp.webservice.pojo.TestPojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class SSDSApplication {
	
	private static List<HttpMessageConverter<?>> getMessageConverters() {
	    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
	    converters.add(new MappingJacksonHttpMessageConverter());
	    return converters;
	}	

	public static void main(String[] args) {
		 RestTemplate restTemplate = new RestTemplate();
	        
	        restTemplate.setMessageConverters(getMessageConverters());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	                
	        ResponseEntity<TestPojo> response = 
	        	      restTemplate.exchange("http://localhost:8080/SSDSV2.1/webapi/getLin", HttpMethod.GET, entity, TestPojo.class);
	        TestPojo testPojo = response.getBody();
	        System.out.println("key :" + testPojo.getKey());
	        System.out.println("Value :" + testPojo.getValue());
	        
	        /*System.out.println("Name:    " + page.getId());
	        System.out.println("About:   " + page.getFirst_name());
	        System.out.println("Phone:   " + page.getLast_name());
	        System.out.println("Website: " + page.getMiddle_name());
	        System.out.println("Website: " + page.getName());*/

	}

}
