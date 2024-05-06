package com.example.controller;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Song;
import com.example.service.SongService;


@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute Song song) {
		String name = song.getName();

		if (songService.nameExists(name)) {
			System.out.println("Song already exists");
		} else {

			songService.saveSong(song);
			System.out.println("Song added successful");
		}
		return "adminhome.html";

	}
	
	
	@GetMapping("/playsong")
	public String playSong(Model model) {
		boolean premium=true;
		if(premium) {
			
			List<Song> songslist= songService.fetchAllSongs();
			model.addAttribute("songs",songslist);
			System.out.println(songslist);
			return "viewsongs";
		} else {
			return "Payment";
		}
	}
		
		@GetMapping("/viewsong")
		public String viewsong(Model model) {
				
				List<Song> songslist= songService.fetchAllSongs();
				model.addAttribute("songs",songslist);
				System.out.println(songslist);
				return "viewsongs";
			
	}

}
