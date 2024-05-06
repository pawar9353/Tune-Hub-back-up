package com.example.service;

import java.util.List;

import com.example.entity.Song;
import com.example.entity.User;

public interface SongService {

     void saveSong(Song song);

     boolean nameExists(String name);


     boolean nameExists(Song song);

	List<Song> fetchAllSongs();


	void updatesong(Song song);






	
}
