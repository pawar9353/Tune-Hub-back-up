package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.playlist;


@Repository
public interface PlaylistRepository extends JpaRepository<playlist,Integer> {

	public playlist findByName(String string);

}
