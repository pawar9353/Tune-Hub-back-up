package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepository;

	@Override
	public void saveUser(User user) {
		userrepository.save(user);

	}
	 @Override
	    public boolean emailExists(String email) {
	        User existingUser = userrepository.findFirstByEmail(email);
	        return existingUser != null; // Return true if user with email exists, false otherwise
	    }
	@Override
	public boolean emailExists(User user) {
		return true;
	}
	@Override
	public boolean validUser(String email, String password) {
		User user=userrepository.findFirstByEmail(email);
		String dbpawd=user.getPassword();
		if (password.equals(dbpawd)) {
			return true;
			
		} else {

			return false;
		}
	}
	@Override
	public String getRole(String email) {
		User user=userrepository.findFirstByEmail(email);
		return user.getRole();
	}
	@Override
	public User getUser(String mail) {
		return userrepository.findFirstByEmail(mail);
	}
	@Override
	public void updateUser(User user) {
		userrepository.save(user);
		
	}
	
	}

	
	
	
	    
	
	

	


