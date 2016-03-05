package in.skbh.svn.webservice.interceptor.filter.impl;

import in.skbh.svn.webservice.interceptor.filter.CORSFilterDemonInterface;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.annotation.Priority;
import javax.inject.Singleton;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Priority(Priorities.HEADER_DECORATOR)
@Singleton
@Provider
public class CORSResponseFilter implements CORSFilterDemonInterface , WriterInterceptor {

	/* (non-Javadoc)
	 * @see gov.nic.uwp.webservice.interceptor.filter.CORSFilterDemonInterface#CORSFilterInit(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void CORSFilterInit(ContainerRequestContext requestContext,ContainerResponseContext responseContext) throws IOException {
		filter(requestContext,responseContext);
		}
	
	@Override
	public void filter(final ContainerRequestContext requestContext,final ContainerResponseContext responseContext) throws IOException {
		final int ACCESS_CONTROL_MAX_AGE_IN_SECONDS = 1 * 60 *60;
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization,X-Requested-With");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		responseContext.getHeaders().add("Access-Control-Max-Age", ACCESS_CONTROL_MAX_AGE_IN_SECONDS);
		responseContext.getHeaders().add("Web-Serivces-Powered-By", "NIC-INDIA - Shram Suvidha - Unified Portal for Labour and Employment");
			
	}

	 @Override
	    public void aroundWriteTo(WriterInterceptorContext context)throws IOException, WebApplicationException {
		 MultivaluedMap<String,Object> responseContext = context.getHeaders();
		  responseContext.add("Content-Encoding", "gzip");
	    	
	        final OutputStream outputStream = context.getOutputStream();
	        context.setOutputStream(new GZIPOutputStream(outputStream));
	        context.proceed();
	    }
		
	

}
