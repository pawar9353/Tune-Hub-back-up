package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Song;
import com.example.entity.User;
import com.example.service.SongService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	
	@Autowired
	SongService songservice;
	
	
	

	@PostMapping("/register")
//	@ResponseBody
	public String addUser(@ModelAttribute User user) {
		String email = user.getEmail();

		// Check if email already exists
		if (userservice.emailExists(email)) {
//            return "Email already exists"; 
			System.out.println("Duplicate user");

		} else {
			userservice.saveUser(user);
//           return "User added successfully"; 
			System.out.println("User added successfully");
		}
		return "Login";

	}

	@PostMapping("/validate")

	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model) {

		if (userservice.validUser(email, password) == true) {
			session.setAttribute("email", email);
			
			
			
			String role = userservice.getRole(email);
			if (role.equals("admin")) {
				return "adminhome";
			} else {
				User user =userservice.getUser(email);
				boolean userstatus=user.isPremium();
				
				List<Song> fetchAllSongs=songservice.fetchAllSongs();
				model.addAttribute("songs",fetchAllSongs);
				
				model.addAttribute("ispremium",userstatus);	
				return "Customerhome";

			}
		} else {
			return "Login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "Login";
	}

}
