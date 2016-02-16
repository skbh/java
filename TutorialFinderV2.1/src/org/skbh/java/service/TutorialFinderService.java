package org.skbh.java.service;

public class TutorialFinderService {
	public String getBestTutorialSite(String language){
		if (language.equals("java"))
		return "java Brain by koushik";
		else
			return "Language not supported";
		
	}

}
