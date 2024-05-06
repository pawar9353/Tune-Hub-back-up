package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Song;
import com.example.entity.playlist;
import com.example.service.PlaylistService;
import com.example.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistservice;
	
	@Autowired
	SongService songservice;
	
	@Autowired
	PlaylistService playlistService;
	
	
	@GetMapping("/createplaylists")	
	public String createplaylist(Model model) {
		List<Song> songlist=songservice.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "createplaylist";
				
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute playlist play) {
	    String name = play.getName();
	    boolean playlistExists = playlistService.playlistExists(name);

	    if (!playlistExists) {
	        // Add the playlist if it doesn't exist
	        playlistService.addplaylist(play);

	        // Update the song_playlist table
	        List<Song> songs = play.getSongs();
	        if (songs != null) {
	            for (Song song : songs) {
	                song.getPlaylists().add(play);
	                songservice.updatesong(song);
	            }
	        } else {
	            // Handle the case where songs are null
	            System.out.println("No songs added to the playlist.");
	        }
	    } else {
	        System.out.println("Duplicate Playlist");
	    }

	    return "adminhome";
	}

		
	@GetMapping("/viewplaylist")
	public String viewplaylists(Model model) {
		List<playlist> playlist = playlistService.fetchAllPlaylists();
		model.addAttribute("playlist", playlist);
		return "ViewPlaylists";

	}

}
