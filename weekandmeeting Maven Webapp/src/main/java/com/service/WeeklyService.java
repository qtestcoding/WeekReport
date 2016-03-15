/**
 * @package com.service
 * @author cuiyueyang
 * @date 2016-2-29 下午12:58:29
 * @todo TODO
 */
package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.Timer;
import com.dao.DetailDao;
import com.dao.WeeklyDao;
import com.domain.DetailModel;
import com.domain.WeeklyModel;

/**
 * @author cuiyueyang
 * @data 2016-2-29 下午12:58:29
 * @todo TODO
 */
@Service
public class WeeklyService {

	@Autowired
	private WeeklyDao weeklyDao;
	@Autowired
	private DetailDao detailDao;
	
	/**
	 * 新增周报
	 * @param weeklyModel
	 * @param detailModel
	 * @return
	 */
	public int addWeekly(WeeklyModel weeklyModel, DetailModel detailModel){
		weeklyDao.addWeekly(weeklyModel);
		detailModel.setWeeklyid(weeklyModel.getId());
		detailDao.addDetail(detailModel);
		return weeklyModel.getId();
	}
	
	/**
	 * 查看我的周报
	 * @param username
	 * @return
	 */
	public List<WeeklyModel> findWeeklysByName(String username){
		ArrayList<WeeklyModel> weeklyModels = new ArrayList<WeeklyModel>();
		weeklyModels = weeklyDao.findWeeklysByName(username);
		return weeklyModels;
	}
	
	/**
	 * 查看本周所有周报
	 * @return
	 */
	public List<WeeklyModel> findWeeklysByThis(){
		ArrayList<WeeklyModel> weeklyModels = new ArrayList<WeeklyModel>();
		Date date = new Date();
		weeklyModels = weeklyDao.findWeeklysByThis(Timestamp.valueOf(Timer.getStartTime(date)), 
				Timestamp.valueOf(Timer.getEndTime(date)));
		return weeklyModels;
	}
	
	/**
	 * 根据username和时间范围查找
	 * @param username
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<WeeklyModel> searchWeeklys(String username, Timestamp starttime, Timestamp endtime){
		ArrayList<WeeklyModel> weeklyModels = new ArrayList<WeeklyModel>();
		weeklyModels = weeklyDao.findWeeklysByNameAndTime(username, starttime, endtime);
		return weeklyModels;
	}
	
	/**
	 * 更新周报
	 * @param detailModel
	 */
	public void updateDetail(DetailModel detailModel){
		detailModel.setLasteditedtime(new Timestamp(System.currentTimeMillis()));
		detailDao.updateDetail(detailModel);
	}
	
	/**
	 * 查找周报简略内容
	 * @param id
	 * @return
	 */
	public WeeklyModel findWeeklyByWeeklyid(String id){
		WeeklyModel weeklyModel = new WeeklyModel();
		weeklyModel = weeklyDao.findWeeklyByWeeklyid(Integer.valueOf(id));
		return weeklyModel;
	}
	
	/**
	 * 查找周报详细内容
	 * @param id
	 * @return
	 */
	public DetailModel findDetailById(String id){
		DetailModel detailModel = new DetailModel();
		detailModel = detailDao.findDetailByWeeklyid(Integer.valueOf(id));
		return detailModel;
	}
}
