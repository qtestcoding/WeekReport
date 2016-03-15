/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午5:30:03
 * @todo TODO
 */
package com.dao;

import com.domain.DetailModel;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午5:30:03
 * @todo TODO
 */
public interface DetailDao {
	
	public DetailModel findDetailByWeeklyid(int weeklyid);
	
	public void addDetail(DetailModel detailModel);
	
	public void updateDetail(DetailModel detailModel);

}
