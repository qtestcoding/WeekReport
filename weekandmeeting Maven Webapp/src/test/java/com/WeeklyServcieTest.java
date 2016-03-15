/**
 * @package com
 * @author cuiyueyang
 * @date 2016-2-29 下午1:10:51
 * @todo TODO
 */
package com;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.com.Timer;
import com.domain.DetailModel;
import com.domain.WeeklyModel;
import com.service.WeeklyService;

/**
 * @author cuiyueyang
 * @data 2016-2-29 下午1:10:51
 * @todo TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class WeeklyServcieTest {
	
	@Autowired
	private WeeklyService service;

//	@Test
	public void run(){
		WeeklyModel weeklyModel = new WeeklyModel();
		weeklyModel.setTitle("崔岳阳的团队周报(2016.02.29-2016.03.06)");
		weeklyModel.setType("1");
		weeklyModel.setIslatesubmit("1");
		weeklyModel.setUsername("cuiyueyang");
//		weeklyModel.setTitle("薛晨的个人周报(2016.02.29-2016.03.06)");
//		weeklyModel.setType("1");
//		weeklyModel.setIslatesubmit("1");
//		weeklyModel.setUsername("liujiaqi");
		
		DetailModel detailModel = new DetailModel();
		detailModel.setMembers("崔岳阳、魏丕东、刘佳奇、孙姝儒、薛晨、王翠、赵娜");
//		detailModel.setMembers("薛晨");
		detailModel.setImportant("本周天擎虚拟化海关版本patch8合并");
		detailModel.setTasknum(1);
		detailModel.setRunnum(1);
		detailModel.setOnlinenum(0);
		detailModel.setBugnum(20);
		detailModel.setBusiness("patch8合并，60%");
		detailModel.setDescription("[自动化]，本周完成自动化exe的编写，交付使用");
		detailModel.setNext("下周继续加油");
		
		service.addWeekly(weeklyModel,detailModel);
		System.out.println("insert id:"+weeklyModel.getId());
	}
	
//	@Test
	public void find(){
		List<WeeklyModel> weeklyModels = service.findWeeklysByName("cuiyueyang");
		for (WeeklyModel weeklyModel : weeklyModels) {
			System.out.println("id:"+weeklyModel.getId());
			System.out.println("title:"+weeklyModel.getTitle());
			System.out.println("type:"+weeklyModel.getType());
			System.out.println("username:"+weeklyModel.getUsername());
			System.out.println("islatesubmit:"+weeklyModel.getIslatesubmit());
			System.out.println("createtime:"+weeklyModel.getCreatetime());
		}
	}
	
//	@Test
	public void update(){
		DetailModel detailModel = new DetailModel();
		detailModel.setBusiness("patch8完成测试，100%");
		detailModel.setTasknum(10);
		detailModel.setOnlinenum(1);
		detailModel.setBugnum(200);
		detailModel.setWeeklyid(4);
		service.updateDetail(detailModel);
	}
	
//	@Test
	public void findByThis(){
		List<WeeklyModel> weeklyModels = service.findWeeklysByThis();
		System.out.println("count:"+weeklyModels.size());
		for (WeeklyModel weeklyModel : weeklyModels) {
			System.out.println("id:"+weeklyModel.getId());
			System.out.println("title:"+weeklyModel.getTitle());
			System.out.println("type:"+weeklyModel.getType());
			System.out.println("username:"+weeklyModel.getUsername());
			System.out.println("islatesubmit:"+weeklyModel.getIslatesubmit());
			System.out.println("createtime:"+weeklyModel.getCreatetime());
		}
	}
	
	@Test
	public void search(){
		List<WeeklyModel> weeklyModels = service.searchWeeklys("cuiyueyang", Timestamp.valueOf("2016-02-28 14:06:29"), 
				Timestamp.valueOf("2016-02-29 20:20:29"));
		System.out.println("count:"+weeklyModels.size());
		for (WeeklyModel weeklyModel : weeklyModels) {
			System.out.println("id:"+weeklyModel.getId());
			System.out.println("title:"+weeklyModel.getTitle());
			System.out.println("type:"+weeklyModel.getType());
			System.out.println("username:"+weeklyModel.getUsername());
			System.out.println("islatesubmit:"+weeklyModel.getIslatesubmit());
			System.out.println("createtime:"+weeklyModel.getCreatetime());
		}
	}
}
