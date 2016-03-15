/**
 * @package com
 * @author cuiyueyang
 * @date 2016-2-29 下午4:23:10
 * @todo TODO
 */
package com;

import java.util.Calendar;
import java.util.Date;

import com.com.Timer;

/**
 * @author cuiyueyang
 * @data 2016-2-29 下午4:23:10
 * @todo TODO
 */
public class TimerTest {
	
	public static void main(String[] args){
		Date date = new Date();
		System.out.println("本星期开始的时间节点："+Timer.getStartTime(date));
		System.out.println("本星期最后的时间节点:"+Timer.getEndTime(date));
		
		Calendar calendar = Calendar.getInstance();//日历对象
		calendar.setTime(date);//设置当前日期
		calendar.add(Calendar.DATE, +11);
		System.out.println("本星期开始的时间节点："+Timer.getStartTime(calendar.getTime()));
		System.out.println("本星期最后的时间节点:"+Timer.getEndTime(calendar.getTime()));
	}

}
