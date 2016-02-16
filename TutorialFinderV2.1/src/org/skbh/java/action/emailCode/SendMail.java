package org.skbh.java.action.emailCode;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class SendMail extends ActionSupport {

	  private static final long serialVersionUID = -1641203207124447600L;
  	  public String emailPassword(String uPass,String Uname,String Uemail)  {

	        final String username = "anurag.apll@gmail.com";
	        final String password = "apllanurag";

	        Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("anurag.apll@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(Uemail));
	            message.setSubject("Testing Subject");
	            message.setText("Dear  " + Uname  + "," + "\n\n Your Access Password :" + uPass);
	            
	            Transport.send(message);
	            System.out.println("Email Sent Done");
	            //addActionMessage("Email Has Sent to :" + Uemail);
	            return "success";

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	           
	        }
	    }
	}

