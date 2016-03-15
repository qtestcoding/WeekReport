/**
 * @package com
 * @author cuiyueyang
 * @date 2016-3-8 下午1:02:22
 * @todo TODO
 */
package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author cuiyueyang
 * @data 2016-3-8 下午1:02:22
 * @todo TODO
 */
public class TimerMenu {
	
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long diff = sdf.parse("2016-03-08").getTime() - sdf.parse("2016-03-09").getTime();
		System.out.println("day:"+(diff/1000*24*60*60));
	}

}
