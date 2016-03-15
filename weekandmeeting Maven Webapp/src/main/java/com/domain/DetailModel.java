/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午3:10:47
 * @todo TODO
 */
package com.domain;

import java.sql.Timestamp;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午3:10:47
 * @todo TODO
 */
public class DetailModel{

	private int id;
	private int weeklyid;
	private String members;
	private String important;
	private int tasknum;
	private int onlinenum;
	private int runnum;
	private int bugnum;
	private String business;
	private String description;
	private String next;
	private Timestamp lasteditedtime;
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
	 * @return the weeklyid
	 */
	public int getWeeklyid() {
		return weeklyid;
	}
	/**
	 * @param weeklyid the weeklyid to set
	 */
	public void setWeeklyid(int weeklyid) {
		this.weeklyid = weeklyid;
	}
	/**
	 * @return the members
	 */
	public String getMembers() {
		return members;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(String members) {
		this.members = members;
	}
	/**
	 * @return the important
	 */
	public String getImportant() {
		return important;
	}
	/**
	 * @param important the important to set
	 */
	public void setImportant(String important) {
		this.important = important;
	}
	/**
	 * @return the tasknum
	 */
	public int getTasknum() {
		return tasknum;
	}
	/**
	 * @param tasknum the tasknum to set
	 */
	public void setTasknum(int tasknum) {
		this.tasknum = tasknum;
	}
	/**
	 * @return the onlinenum
	 */
	public int getOnlinenum() {
		return onlinenum;
	}
	/**
	 * @param onlinenum the onlinenum to set
	 */
	public void setOnlinenum(int onlinenum) {
		this.onlinenum = onlinenum;
	}
	/**
	 * @return the runnum
	 */
	public int getRunnum() {
		return runnum;
	}
	/**
	 * @param runnum the runnum to set
	 */
	public void setRunnum(int runnum) {
		this.runnum = runnum;
	}
	/**
	 * @return the bugnum
	 */
	public int getBugnum() {
		return bugnum;
	}
	/**
	 * @param bugnum the bugnum to set
	 */
	public void setBugnum(int bugnum) {
		this.bugnum = bugnum;
	}
	/**
	 * @return the business
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * @param business the business to set
	 */
	public void setBusiness(String business) {
		this.business = business;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * @return the lasteditedtime
	 */
	public Timestamp getLasteditedtime() {
		return lasteditedtime;
	}
	/**
	 * @param lasteditedtime the lasteditedtime to set
	 */
	public void setLasteditedtime(Timestamp lasteditedtime) {
		this.lasteditedtime = lasteditedtime;
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
