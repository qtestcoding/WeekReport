/**
 * @package com
 * @author cuiyueyang
 * @date 2016-2-26 下午5:02:24
 * @todo TODO
 */
package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.UserModel;
import com.service.UserService;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午5:02:24
 * @todo TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@Test
	public void hashMatchUser(){
		boolean re = service.hasMatchUser("cuiyueyang");
		System.out.println("Re:"+re);
		boolean rx = service.hasMatchUser("weipidong");
		System.out.println("Rx:"+rx);
		UserModel model = service.findUserByName("weipidong");
		System.out.println("model:"+model);
		System.out.println("id:"+model.getId());
		System.out.println("lasttime:"+model.getLasttime());
	}
}
