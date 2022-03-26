package com.training.ers.model;

import java.util.Objects;

public class User {	
	private int userId;
	private String username;
	private String passwords;
	private String gender;
	private String notifications;
	private String qualification;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String username, String passwords, String gender, String notifications,
			String qualification) {
		super();
		this.userId = userId;
		this.username = username;
		this.passwords = passwords;
		this.gender = gender;
		this.notifications = notifications;
		this.qualification = qualification;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public String getQualification() {
		return qualification;
	}

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
		User other = (User) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(notifications, other.notifications)
				&& Objects.equals(passwords, other.passwords) && Objects.equals(qualification, other.qualification)
				&& userId == other.userId && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		
		return "User [userId=" + userId + ", username=" + username + ", passwords=" + passwords + ", gender=" + gender
				+ ", notifications=" + notifications + ", qualification=" + qualification + "]"+"\n" ;
	}
		
}
