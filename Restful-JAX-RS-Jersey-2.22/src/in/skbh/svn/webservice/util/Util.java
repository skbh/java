
package in.skbh.svn.webservice.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {

    /** The Constant pfdMagicHeader. */
    private static final int[] pfdMagicHeader = new int[] { 0x25,0x50,0x44,0x46,0x2d,0x31,0x2e,0x35 };
    
    /** The Constant jpgMagicHeader. */
    private static final int[] jpgMagicHeader = new int[] { 0xff,0xd8,0xff,0xe0,0x0,0x10,0x4a,0x46 };

	/** The logger. */
	private static Logger logger = Logger.getLogger(Util.class);
	
	/** The email_matcher. */
	private static Matcher email_matcher;

	
	
	/**
	 * Generate reference number using secure random generator.(For ECR)
	 *
	 * @return the integer
	 */
	public static Integer generateReferenceNumberNumberUsingSecureRandomGenerator() {
		Integer referenceNumber=null;
		Integer generatorlimit=100000000;
	    try {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");//secure random number generator SHA1PRNG algorithm
		
		byte[] randomBytes = new byte[128];// Get 128 random bytes
		secureRandomGenerator.nextBytes(randomBytes);
		int seedByteCount = 5;// Create seed
		byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(seed);
		referenceNumber=secureRandom.nextInt(generatorlimit);
			
	    } catch (NoSuchAlgorithmException e) {
	    	if (logger.isDebugEnabled()) {
	    		logger.info("____Please view PrepareECRAction that called this method____");
				logger.debug("generateReferenceNumberNumberUsingSecureRandomGenerator error # "+  e);
			}
	    	return null;
	    }
		return referenceNumber;
	 
	  }
	
	public boolean isObjectNotNull(Object tocheck) {
		if (tocheck!=null)
			return true;
		return false;
	}
	
	/**
	 * Gets the ip address.
	 *
	 * @param request the request
	 * @return the ip address
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
	/**
	 * Http tohttps.
	 *
	 * @param url the url
	 * @return the string
	 */
	/* due to SSL certificate installation on LOAD balancer server, WebService Could not have found SSL
	 * that'why i used httpTohttps(String Url) to get it done suggested by Abhinash Sir*/
	public static String httpTohttps(String url){
		StringBuilder newUrl=new StringBuilder(url);
		if(!url.startsWith("https")){
		newUrl.insert(4,'s');
		url=newUrl.toString();
		}
		return url;
		
	}
	
	
	/**
	 * Hide digits with xxx in phone number.
	 *
	 * @param phone the phone
	 * @return the string
	 */
	public static String hideDigitsWithXXXInPhoneNumber(String phone){
		StringBuilder hidePhone=new StringBuilder(phone);
		String str="XXXX";
		hidePhone.replace(2, 6, str);
		return hidePhone.toString();
		
	}
	
	/**
	 * Checks if is null or blank.
	 *
	 * @param str the str
	 * @return true, if is null or blank
	 */
	public static boolean isNullOrBlank(String str) {

		return (str == null) || (str.trim().length() == 0);
	}


	/**
	 * Gets the lin format.
	 *
	 * @param linNo the lin no
	 * @return the lin format
	 */
	public static String getLinFormat(String linNo){
		String splitLin=linNo.substring(0, 1)+ "-"+ linNo.substring(1, 5)+ "-"+linNo.substring(5, 9) + "-"+linNo.substring(9,10);

		return splitLin;
	}

	/**
	 * Gets the jurisdiction for epfo.
	 *
	 * @param establishmentid the establishmentid
	 * @return the jurisdiction for epfo
	 */
	public static String getJurisdictionForEPFO(String establishmentid){
		String epfo_char=establishmentid.substring(2, 5);
		return epfo_char;
	}


	/**
	 * Gets the jurisdiction for epfo states.
	 *
	 * @param establishmentid the establishmentid
	 * @return the jurisdiction for epfo states
	 */
	public static String getJurisdictionForEPFOStates(String establishmentid){
		String state_char=establishmentid.substring(0,2);
		return state_char;
	}


	/**
	 * Checks if is contain valid characters.
	 *
	 * @param str the str
	 * @return true, if is contain valid characters
	 */
	public static boolean isContainValidCharacters(String str) {

		if(!isNullOrBlank(str)) {

			Pattern invalidCharacterPattern = Pattern.compile("[a-zA-Z0-9 \\t\\n\\r\\v\\f\"`.,'&/!@#$%~:?()\\-\\_+|]*");
			Matcher invalidCharacterMatcher =  invalidCharacterPattern.matcher(str);

			return invalidCharacterMatcher.matches();
		}

		return false;
	}


	//TODO: Fix: Email function is accepting firstname.lastname@company.abcdef. But this is not intentional.
	/**
	 * Checks if is email address valid.
	 *
	 * @param emailAddress the email address
	 * @return true, if is email address valid
	 */
	public static boolean isEmailAddressValid(String emailAddress) {

		if (!isNullOrBlank(emailAddress)) {

			setEmail_matcher(null);

			Pattern email_pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");
			Pattern email_pattern1 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");
			Pattern email_pattern2 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");

			if(email_pattern.matcher(emailAddress).matches()){

				setEmail_matcher(email_pattern.matcher(emailAddress));

				return true;
			}

			if(email_pattern1.matcher(emailAddress).matches()){

				setEmail_matcher(email_pattern.matcher(emailAddress));
				return true;
			}

			if(email_pattern2.matcher(emailAddress).matches()){

				setEmail_matcher(email_pattern.matcher(emailAddress));
				return true;
			}

		}

		return false;
	}

	/**
	 * Checks if is alpha numeric.
	 *
	 * @param obj the obj
	 * @return true, if is alpha numeric
	 */
	public static boolean isAlphaNumeric(String obj) {

		return obj.matches("[0-9A-Za-z]*");
	}

	/**
	 * Checks if is alphabets.
	 *
	 * @param obj the obj
	 * @return true, if is alphabets
	 */
	public static boolean isAlphabets(String obj) {

		return obj.matches("[ A-Za-z]+");
	}


	/**
	 * Escape special chars.
	 *
	 * @param str the str
	 * @return the string
	 */
	@SuppressWarnings("unused")
	private static String escapeSpecialChars(String str)	{

		if (!isNullOrBlank(str)) {

			str = str.replace("'", "\\'");
		}

		return str;
	}

	//TODO: Check whether this method follows NIC security policy
	/**
	 * Checks if is valid user id.
	 *
	 * @param str the str
	 * @return true, if is valid user id
	 */
	public static boolean isValidUserId(String str) {

		if (!isNullOrBlank(str)) {

			@SuppressWarnings("unused")
			Matcher userid_matcher=null;


			Pattern email_pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");
			Pattern email_pattern1 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");
			Pattern email_pattern2 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._\\-]*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?+[.][a-zA-Z]{2,3}[.]?([a-zA-Z]{2,2})?");


			if(email_pattern.matcher(str).matches()){

				userid_matcher = email_pattern.matcher(str);

				return true;
			}

			if(email_pattern1.matcher(str).matches()){

				userid_matcher = email_pattern.matcher(str);
				return true;
			}

			if(email_pattern2.matcher(str).matches()){

				userid_matcher = email_pattern.matcher(str);
				return true;
			}

		}

		return false;
	}

	/**
	 * Checks if is valid password.
	 *
	 * @param password the password
	 * @return true, if is valid password
	 */
	public static boolean isValidPassword(String password) {

		if (password != null && password.length() >= 8)	{

			Pattern smallLetterPattern = Pattern.compile(".*[a-z]+.*");
			Pattern capitalLetterPattern = Pattern.compile(".*[A-Z]+.*");
			Pattern digitPattern = Pattern.compile(".*[0-9]+.*");
			Pattern specialCharacterPattern = Pattern.compile(".*[\"`.,'&/!@#$%~:<>?()\\-\\_+|]+.*");

			Matcher smallLetterMatcher = smallLetterPattern.matcher(password);
			Matcher capitalLetterMatcher = capitalLetterPattern.matcher(password);
			Matcher digitMatcher = digitPattern.matcher(password);
			Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);

			if(isContainValidCharacters(password) && smallLetterMatcher.matches() && capitalLetterMatcher.matches() && digitMatcher.matches() && specialCharacterMatcher.matches()) {

				return true;
			}
		}

		return false;
	}

	/**
	 * Encode sh a512.
	 *
	 * @param password the password
	 * @return the string
	 */
	public static String encodeSHA512(String password) {

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-512");

			md.update(password.getBytes());
			byte[] dataBytes = md.digest();

			//convert byte[] to HexFormat
			StringBuffer hexString = new StringBuffer();

			for(int i = 0; i < dataBytes.length; i++) {

				String hex = Integer.toHexString(0xff & dataBytes[i]);

				if(hex.length() == 1) {

					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();

		}catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Gets the day differrence between two dates.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return the day differrence between two dates
	 */
	public static long getDayDifferrenceBetweenTwoDates(Date date1, Date date2) {

		long dayDiff = 0;

		try {

			long diff = (date1.getTime() - date2.getTime());

			dayDiff = diff / (24 * 60 * 60 * 1000);

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return dayDiff;
	}

	/**
	 * Gets the time stamp.
	 *
	 * @return the time stamp
	 */
	public static String getTimeStamp() {

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSa");
		String timeStamp = sdf.format(new Date());
		return timeStamp;
	}

	/**
	 * Checks if is not null.
	 *
	 * @param obj the obj
	 * @return true, if is not null
	 */
	public static boolean isNotNull(Object obj)
	{
		return (obj != null);
	}

	/**
	 * Checks if is numeric.
	 *
	 * @param obj the obj
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String obj)
	{
		return obj.matches("[0-9]*");
	}
	
	/**
	 * Checks if is double.
	 *
	 * @param obj the obj
	 * @return true, if is double
	 */
	public static boolean isDouble(String obj)
	{
		return obj.matches("[0-9]*.*");
	}

	/**
	 * Checks if is numeric character.
	 *
	 * @param obj the obj
	 * @return true, if is numeric character
	 */
	public static boolean isNumericCharacter(String obj)
	{
		return obj.matches(".*\\d.*");
	}

	/**
	 * Generate random number.
	 *
	 * @return the int
	 */
	public static int generateRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(2147483647);

		if (randomNumber < 99999)
		{
			randomNumber += 11111;
		}

		return randomNumber;
	}

	
	/**
	 * Checks if is this date valid.
	 *
	 * @param dateToValidate the date to validate
	 * @param Dateformat the dateformat
	 * @return true, if is this date valid
	 */
	public static boolean isThisDateValid(String dateToValidate, String Dateformat){
			if(dateToValidate.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})") && dateToValidate.length()==10 && toCheckValidDate(dateToValidate, Dateformat))
			return true;
		return false;
	}


	/**
	 * To check valid date.
	 *
	 * @param dateToValidate the date to validate
	 * @param dateFromat the date fromat
	 * @return true, if successful
	 */
	private static boolean toCheckValidDate(String dateToValidate,
			String dateFromat) {
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Checks if is this date valid1.
	 *
	 * @param dateToValidate the date to validate
	 * @param dateFromat the date fromat
	 * @return true, if is this date valid1
	 */
	public static boolean isThisDateValid1(String dateToValidate, String dateFromat){

		return toCheckValidDate(dateToValidate, dateFromat);
	}
	
	/**
	 * Gets the jurisdiction for esic.
	 *
	 * @param esic the esic
	 * @return the jurisdiction for esic
	 */
	public static String getJurisdictionForESIC(String esic) {
		//System.out.println("===========ESIC"+esic);
		String esic_char=esic.substring(0, 2);
		return esic_char;
	}

	/**
	 * Validate pan.
	 *
	 * @param pan the pan
	 * @return the boolean
	 */
	public static Boolean validatePAN(String pan){

		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher = pattern.matcher(pan);
		if (matcher.matches()) {

			return true;
		}else{

			return false;
		}

	}
	

	/**
	 * Validate epfo.
	 *
	 * @param epfo the epfo
	 * @return the boolean
	 */
	public static Boolean validateEPFO(String epfo){

		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{10}");
		Matcher matcher = pattern.matcher(epfo);
		if (matcher.matches()) {

			return true;
		}else{

			return false;
		}

	}


	/**
	 * Checks if is alpha numeric key word.
	 *
	 * @param str the str
	 * @return true, if is alpha numeric key word
	 */
	public static boolean isAlphaNumericKeyWord(String str) {

		if(!isNullOrBlank(str)) {

			Pattern invalidCharacterPattern = Pattern.compile("[- a-zA-Z0-9 \\t\\n\\r\\v\\f\" ., : - _/\'&()]*");
			Matcher invalidCharacterMatcher =  invalidCharacterPattern.matcher(str);

			return invalidCharacterMatcher.matches();
		}

		return false;
	}

	/**
	 * Checks if is valid name.
	 *
	 * @param str the str
	 * @return true, if is valid name
	 */
	public static boolean isValidName(String str) {

		if(!isNullOrBlank(str)) {

			Pattern invalidCharacterPattern = Pattern.compile("[ a-zA-Z. ]*");
			Matcher invalidCharacterMatcher =  invalidCharacterPattern.matcher(str);

			return invalidCharacterMatcher.matches();
		}

		return false;
	}
	
	
	/**
	 * Gets the file extension.
	 *
	 * @param file the file
	 * @return the file extension
	 * @throws Exception the exception
	 */
	public static String getFileExtension(String file)throws Exception {
		
        String fileName = file;
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
        	
        	System.out.println("File Extension:"+fileName.substring(fileName.lastIndexOf(".")+1));
        	return fileName.substring(fileName.lastIndexOf(".")+1);
        }
        else
        	return "";
    }


	/*public  String getDistrictName(String districtCode)
	{
		System.out.println("public static String getDistrictName(String districtCode) : " +districtCode);
		System.out.println("dropDownUtilMgr:"+dropDownUtilService);
		RefDistrict refDistrict = dropDownUtilService.getDistrictByCode(districtCode);
		return refDistrict.getDistrictName();
	}
	
	public  String getRefStateByCode(String stateCode)
	{
		System.out.println("public static String getRefStateByCode(String stateCode) : " +stateCode);
		RefState refState = dropDownUtilService.getRefStateByCode(stateCode);
		return refState.getStateName();
	}*/
	 
		/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public  static String getURL()
		{
			InputStream emailPropertiesIS = Util.class.getResourceAsStream("/email.properties");
			Properties configProp = new Properties();

			try {
				configProp.load(emailPropertiesIS);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(configProp.getProperty("email.url"));

			return configProp.getProperty("email.url").trim();
		}

		
		//TODO - monk
	    /**
		 * Checks if is pdf or jpg.
		 *
		 * @param file the file
		 * @return true, if is pdf or jpg
		 */
		public static boolean isPdfOrJpg(File file) {
	    	//String fileName = file.getName().toUpperCase();
			try {
				@SuppressWarnings("resource")
				FileInputStream ins = new FileInputStream(file);
				for (int i = 0; i < 8; i++) {
					int ch = ins.read();
					if (ch == pfdMagicHeader[i]) {
						return true; 
					}
					if (ch == jpgMagicHeader[i]) {
						return true;
					}
				}
				ins.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}


		/**
		 * Gets the logger.
		 *
		 * @return the logger
		 */
		public static Logger getLogger() {
			return logger;
		}


		/**
		 * Sets the logger.
		 *
		 * @param logger the new logger
		 */
		public static void setLogger(Logger logger) {
			Util.logger = logger;
		}


		/**
		 * Gets the email_matcher.
		 *
		 * @return the email_matcher
		 */
		public static Matcher getEmail_matcher() {
			return email_matcher;
		}


		/**
		 * Sets the email_matcher.
		 *
		 * @param email_matcher the new email_matcher
		 */
		public static void setEmail_matcher(Matcher email_matcher) {
			Util.email_matcher = email_matcher;
		}
	   
	  /*  public static void main(String[] args) {
	         String rootPath = "E:\\";
	         File OriginalTempFile = new File(rootPath + File.separatorChar + "client24.tmp");
	         System.out.println(isPdfOrJpg(OriginalTempFile));
	         
		}*/
		
		/**
  	 * Is name not null.
  	 *
  	 * @param tocheck the tocheck
  	 * @return the string
  	 */
  	public static String isNameNotNull(String tocheck) {
			if (!StringUtils.isEmpty(tocheck))
				return tocheck;
			return " ";
		}
  	
  	
  

	/**
	 * Checks if is number or not.
	 *
	 * @param inputYear the input year
	 * @return true, if is number or not
	 */
	public static boolean isNumberOrNot(String inputYear) {
		try
		{
			Integer.parseInt(inputYear);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
	}
}