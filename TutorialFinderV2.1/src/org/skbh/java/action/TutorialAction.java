
package org.skbh.java.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.skbh.java.service.TutorialFinderService;

import com.opensymphony.xwork2.ActionSupport; 

/**
 * @author sushil kumar bhaskar
 *
 */
public class TutorialAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String BestTutorialSite;
	private String language;
	
	public String getTutorial()	{
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		TutorialFinderService tutorialFinderService=new TutorialFinderService();
		setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
		System.out.println("Best Book Tutorial : " + BestTutorialSite);
		System.out.println(getLanguage());
		System.out.print(" : getTutorial method called : ");
		String LOGIN_OK=(String) session.getAttribute("LOGIN_OK");
		String userid=(String) session.getAttribute("userid");
		System.out.print(LOGIN_OK);
		if(LOGIN_OK=="true" && userid!=null)
		return SUCCESS;
		return LOGIN;
		 
	}

	

	public String addTutorial()
	{
		
		System.out.print(" : addTutorial called : ");
		return "success";
		
	}
	
	
	public String getBestTutorialSite() {
		return BestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		BestTutorialSite = bestTutorialSite;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
