package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class playlist {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id

	private int id;
	private String name;
	@ManyToMany
	private List<Song> song;

	public playlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public playlist(int id, String name, List<Song> song) {
		super();
		this.id = id;
		this.name = name;
		this.song = song;
	}

	

	@Override
	public String toString() {
		return "playlist [id=" + id + ", name=" + name + "]";
	}

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

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

	public List<Song> getSongs() {
		// TODO Auto-generated method stub
		return null;
	}

}
