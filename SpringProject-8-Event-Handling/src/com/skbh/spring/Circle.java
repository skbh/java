package com.skbh.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


// 
//@Repository
//@Controller
//@Service

@Component //equals to <bean id="circle" class="com.skbh.spring.Circle"></bean>
public class Circle implements Shape , ApplicationEventPublisherAware{
	
	private Point center;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
	
	@Override
	public void Draw() {
		System.out.println(this.getMessageSource().getMessage("drawing.point", new Object[] { center.getX(),center.getY()}, "default message" , null));
		System.out.print(this.getMessageSource().getMessage("drawing.circle", null, "default message" , null));
		System.out.println("( " + getCenter().getX() + " , "+ getCenter().getY() + " )");
		System.out.println(this.getMessageSource().getMessage("greeting", null, "default Greeting", null));
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}


}
