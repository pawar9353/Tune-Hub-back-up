package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Song;

@Controller
public class NavigationController {
	
	@GetMapping("/login")
	public String login () {
		return "login";
		
	}
	
	@GetMapping("/registartion")
	public String registarion () {
		return "Registeration";
		
	}
	@GetMapping("/addsong")
	public String addsong () {
		return "song";
		
	}
	
	
	
	
	
}
