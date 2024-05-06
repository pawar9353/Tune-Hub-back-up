package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Song;


@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

	Song findFirstByName(String name);



}
