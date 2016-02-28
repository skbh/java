package webservice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@RequestMapping(value = "/listUsers", produces = "application/json", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://graph.facebook.com/skbh86";
		List<Message> Message = (List<Message>) restTemplate.getForObject(url,
				Message.class);
		System.out.println(Message);
		return new ModelAndView("listUsers", "Message", Message);
	}

}
