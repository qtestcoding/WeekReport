/**
 * @package com.dao
 * @author cuiyueyang
 * @date 2016-2-26 下午3:03:34
 * @todo TODO
 */
package com.domain;

import java.sql.Timestamp;

/**
 * @author cuiyueyang
 * @data 2016-2-26 下午3:03:34
 * @todo TODO
 */
public class UserModel{
	
	private int id;
	private String username;
	private String password;
	private String realname;
	private String type;
	private String email;
	private String members;
	private int visits;
	private String ip;
	private Timestamp lasttime;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the visits
	 */
	public int getVisits() {
		return visits;
	}
	/**
	 * @param visits the visits to set
	 */
	public void setVisits(int visits) {
		this.visits = visits;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the lasttime
	 */
	public Timestamp getLasttime() {
		return lasttime;
	}
	/**
	 * @param lasttime the lasttime to set
	 */
	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}
}
