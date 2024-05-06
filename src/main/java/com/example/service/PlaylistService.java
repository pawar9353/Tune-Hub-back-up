package com.example.service;

import java.util.List;

import com.example.entity.playlist;

public interface PlaylistService {

	public void addplaylist(playlist play);

//	public String addPlaylist(playlist playlist);

	public boolean playlistExists(String name);

	public List<playlist> fetchAllPlaylists();




}
