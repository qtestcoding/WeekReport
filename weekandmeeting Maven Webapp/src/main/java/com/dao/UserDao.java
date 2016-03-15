/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午3:29:24
 * @todo TODO
 */
package com.dao;

import com.domain.UserModel;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午3:29:24
 * @todo TODO
 */
public interface UserDao {

	public int getMatchCount(String username);
	
	public void updateVisits(UserModel userModel);
	
	public UserModel findUserByName(String username);
	
}
