/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午5:29:52
 * @todo TODO
 */
package com.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.domain.WeeklyModel;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午5:29:52
 * @todo TODO
 */
public interface WeeklyDao {
	
	public WeeklyModel findWeeklyByWeeklyid(int id);
	
	public ArrayList<WeeklyModel> findWeeklysByName(String username);

	public void addWeekly(WeeklyModel weeklyModel);
	
	public ArrayList<WeeklyModel> findWeeklysByThis(@Param("starttime")Timestamp starttime, @Param("endtime")Timestamp endtime);

	public ArrayList<WeeklyModel> findWeeklysByNameAndTime(@Param("username")String username, @Param("starttime")Timestamp starttime, @Param("endtime")Timestamp endtime);
}
