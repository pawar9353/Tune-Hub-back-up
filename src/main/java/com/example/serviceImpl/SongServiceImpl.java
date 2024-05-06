package com.example.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Song;
import com.example.entity.User;
import com.example.repository.SongRepository;
import com.example.service.SongService;


@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	SongRepository songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
		
	}

	@Override
	public boolean nameExists(String name) {
		Song existingSong =songRepository.findFirstByName(name);
		return existingSong !=null;
	}
	@Override
	public boolean nameExists(Song song) {
		return true;
	 
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs= songRepository.findAll();
		
		return songs;
	}

	@Override
	public void updatesong(Song song) {
		songRepository.save(song);
		
	}

	
	





}
