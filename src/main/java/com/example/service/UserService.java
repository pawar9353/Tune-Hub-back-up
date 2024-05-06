package com.example.service;


import com.example.entity.User;


public interface UserService {
	
	public void saveUser (User user);

	public boolean emailExists(User user);

	boolean emailExists(String email);

	public boolean validUser(String email, String password);

	public String getRole(String email);

	public User getUser(String mail);

	public void updateUser(User user);

	

	

	


}
