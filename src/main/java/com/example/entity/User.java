package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String Username;
	private String email;
	private String Password;
	private String Gender;
	private String Role;
	private String Adress;
	private boolean premium;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", Username=" + Username + ", email=" + email + ", Password=" + Password
				+ ", Gender=" + Gender + ", Role=" + Role + ", Adress=" + Adress + ", premium=" + premium + "]";
	}
	public User(int userid, String username, String email, String password, String gender, String role, String adress,
			boolean premium) {
		super();
		this.userid = userid;
		Username = username;
		this.email = email;
		Password = password;
		Gender = gender;
		Role = role;
		Adress = adress;
		this.premium = premium;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}