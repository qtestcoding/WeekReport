/**
 * @package com.service
 * @author cuiyueyang
 * @date 2016-2-26 下午3:56:26
 * @todo TODO
 */
package com.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.domain.UserModel;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午3:56:26
 * @todo TODO
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean hasMatchUser(String userName){
		int count = userDao.getMatchCount(userName);
		if(count > 0){
			Timestamp time = new Timestamp(System.currentTimeMillis());
			UserModel userModel = new UserModel();
			userModel.setUsername(userName);
			userModel.setLasttime(time);
			userDao.updateVisits(userModel);
		}
		return count > 0;
	}
	
	public UserModel findUserByName(String username){
		return userDao.findUserByName(username);
	}
}
