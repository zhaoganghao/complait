package cn.e21.hbjyhf.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar c =  Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.getTimeInMillis());
		
		StringBuffer s=new StringBuffer("seleandctsssand");
		System.out.println(s.substring(0,s.lastIndexOf("and")));
		
		
//		Date date=new Date();
//		Date date1=new Date(60*60*24*365*10);
//		System.out.println(date1.getYear());
//		Long s=date.getTime()-date1.getTime();
//		System.out.println(new Date(s).getYear());
//		System.out.println(new Date().getTime());
//		System.out.println(date1.getTime());
	}

}
