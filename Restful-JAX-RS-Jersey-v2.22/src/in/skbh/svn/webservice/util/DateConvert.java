package in.skbh.svn.webservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateConvert.
 */
public class DateConvert {


	/**
	 * Next date.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date nextDate(Date date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date nextDate = null;
		String formattedDate = formatter.format(date);

		String[] s = formattedDate.split(" ");
		String[] s1 = s[0].split("-");
		int i = Integer.parseInt(s1[2])+1;
		String lastString = s1[0]+"-"+s1[1]+"-"+i+" "+"00:00:00.000";

		try {

			nextDate = formatter.parse(lastString);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return nextDate;
	}

	/**
	 * Change date format.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date changeDateFormat(Date date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date changeDateFormat = null;
		String formattedDate = formatter.format(date);

		try {

			changeDateFormat = formatter.parse(formattedDate);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return changeDateFormat;
	}


	/**
	 * Change date format.
	 *
	 * @param str the str
	 * @return the date
	 */
	public static Date changeDateFormat(String str){


		Date dt = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
		try
		{
			dt = formatter.parse(str);
			return dt;

		}
		
		catch (Exception e)	{
			e.printStackTrace();
		}
			return dt;
	}
	
	/**
	 * Change date format to indian.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String changeDateFormatToIndian(Date date){
		DateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = null;
		dateInString=sdf.format(date);
		return dateInString;
	}
	
	/**
	 * Change date format to indian.
	 *
	 * @param dateInString the date in string
	 * @return the string
	 */
	public static String changeDateFormatToIndian(String dateInString){
		DateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date=sdf.parse(dateInString);
			} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return changeDateFormatToIndian(date);
		
	}
	
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	public static void main(String [] arg){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.DAY_OF_YEAR, 1);    
		Date start = cal.getTime();

		//set date to last day of 2014
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 11); // 11 = december
		cal.set(Calendar.DAY_OF_MONTH, 31); // new years eve

		Date end = cal.getTime();
		System.out.println("start");
		System.out.println(start);
		System.out.println(end);
		}

}
