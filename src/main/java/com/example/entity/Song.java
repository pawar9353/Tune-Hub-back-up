package com.example.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String artist;
	private String genre;
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(int id, String name, String artist, String genre, String link, String audioUrl,
			List<playlist> playlists) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.audioUrl = audioUrl;
		this.playlists = playlists;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", audioUrl=" + audioUrl + ", playlists=" + playlists + "]";
	}
	private String link;
	private String audioUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	public List<playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<playlist> playlists) {
		this.playlists = playlists;
	}
	@ManyToMany
	private List<playlist>playlists;
	
	
}