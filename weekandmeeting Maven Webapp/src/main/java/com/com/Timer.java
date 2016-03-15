/**
 * @package com.com
 * @author cuiyueyang
 * @date 2016-2-29 下午3:17:23
 * @todo TODO
 */
package com.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author cuiyueyang
 * @data 2016-2-29 下午3:17:23
 * @todo TODO
 */
public class Timer {

	public static String getStartTime(Date date){
		int menu;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(1 == dayWeek || 2 == dayWeek){
			menu = 7 - (3 - dayWeek);
		}else{
			menu = dayWeek - 3;
		}
		calendar.add(Calendar.DATE, -menu);
		return sdf.format(calendar.getTime()) + " 00:00:00";
	}
	
	public static String getEndTime(Date date){
		int num;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(1 == dayWeek || 2 == dayWeek){
			num = 2 - dayWeek;;
		}else{
			num = 2 + (7 - dayWeek);
		}
		calendar.add(Calendar.DATE, +num);
		return sdf.format(calendar.getTime()) + " 23:59:59";
	}
	
	public static String getStartDay(Date date){
		int menu;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(1 == dayWeek || 2 == dayWeek){
			menu = 7 - (3 - dayWeek);
		}else{
			menu = dayWeek - 3;
		}
		calendar.add(Calendar.DATE, -menu);
		return sdf.format(calendar.getTime());
	}
	
	public static String getEndDay(Date date){
		int num;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(1 == dayWeek || 2 == dayWeek){
			num = 2 - dayWeek;;
		}else{
			num = 2 + (7 - dayWeek);
		}
		calendar.add(Calendar.DATE, +num);
		return sdf.format(calendar.getTime());
	}
	
	public static boolean checkTime(String datepicker, Date date) throws ParseException{
		boolean bl = false;
		String[] tmp = datepicker.split(" - ");
		String s1 = Timer.getStartDay(date);
		String e1 = Timer.getEndDay(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int sdiff = (int) ((sdf.parse(s1).getTime() - sdf.parse(tmp[0]).getTime())/(1000*24*60*60));
		int ediff = (int) ((sdf.parse(e1).getTime() - sdf.parse(tmp[1]).getTime())/(1000*24*60*60));
		System.out.println("sdiff:"+sdiff);
		System.out.println("ediff:"+ediff);
		if(sdiff <= 1 && sdiff >= 0 && ediff <= 1 && ediff >= 0){
			bl = true;
		}
		System.out.println("rs:"+bl);
		return bl;
	}
}
