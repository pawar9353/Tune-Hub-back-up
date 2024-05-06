package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.playlist;
import com.example.repository.PlaylistRepository;
import com.example.service.PlaylistService;


@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(playlist play) {
		playlistRepository.save(play);
		
	}	
		@Override
		public boolean playlistExists(String name) {
			playlist playlist = playlistRepository.findByName(name);
			
			if (playlist != null) {
				System.out.println("Present");
				return true ;
				
			} else  {
				System.out.println("Absent");
				return false;
				
			}	
	}
		@Override
		public List<playlist> fetchAllPlaylists() {
			List<playlist> playlist= playlistRepository.findAll();
			return playlist;
		
		}
		


	}