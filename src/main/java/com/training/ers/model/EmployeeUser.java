package com.training.ers.model;

import java.util.Comparator;
import java.util.Objects;



public class EmployeeUser implements Comparator<EmployeeUser> {
	
	private int userId;
	private String username;
	private String passwords;
	private String gender;
	private String notifications;
	private String qualification;
	
	public EmployeeUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeUser(int userId, String username, String passwords, String gender, String notifications,
			String qualification) {
		super();
		this.userId = userId;
		this.username = username;
		this.passwords = passwords;
		this.gender = gender;
		this.notifications = notifications;
		this.qualification = qualification;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the passwords
	 */
	public String getPasswords() {
		return passwords;
	}

	/**
	 * @param passwords the passwords to set
	 */
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the notifications
	 */
	public String getNotifications() {
		return notifications;
	}

	/**
	 * @param notifications the notifications to set
	 */
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, notifications, passwords, qualification, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeUser other = (EmployeeUser) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(notifications, other.notifications)
				&& Objects.equals(passwords, other.passwords) && Objects.equals(qualification, other.qualification)
				&& userId == other.userId && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "EmployeeUser [userId=" + userId + ", username=" + username + ", passwords=" + passwords + ", gender="
				+ gender + ", notifications=" + notifications + ", qualification=" + qualification + "]" +"\n";
	}
	
	public int compare(EmployeeUser o1, EmployeeUser o2) {
		
		if(o1.getUserId()<o2.getUserId())
			return 1;
		else if (o1.getUserId() < o2.getUserId())
			return -1;
		else 
			return 0;
	}
		

}
