/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午3:09:00
 * @todo TODO
 */
package com.domain;

import java.sql.Timestamp;


/**
 * @author cuiyueyang
 * @data 2016-2-26 下午3:09:00
 * @todo TODO
 */
public class WeeklyModel{

	private int id;
	private String title;
	private String type;
	private String username;
	private String islatesubmit;
	private String datepicker;
	private Timestamp createtime;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the islatesubmit
	 */
	public String getIslatesubmit() {
		return islatesubmit;
	}
	/**
	 * @param islatesubmit the islatesubmit to set
	 */
	public void setIslatesubmit(String islatesubmit) {
		this.islatesubmit = islatesubmit;
	}
	/**
	 * @return the datepicker
	 */
	public String getDatepicker() {
		return datepicker;
	}
	/**
	 * @param datepicker the datepicker to set
	 */
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	/**
	 * @return the createtime
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
