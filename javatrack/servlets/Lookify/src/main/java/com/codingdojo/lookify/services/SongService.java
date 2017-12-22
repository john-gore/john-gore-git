package com.codingdojo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepo;


@Service
public class SongService {
	private SongRepo songRepo;
	
	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> findAll() {
		return songRepo.findAll();
	}
	
	public void addSong(Song lang) {
		songRepo.save(lang);
	}
	
	public Song getSong(Long id) {
		return songRepo.findOne(id);
	}
	
	public void updateSong(Song song) {
		songRepo.save(song);
	}
	
	public void deleteSong(Long id) {
		songRepo.delete(id);
	}
	public List<Song> searchByArtist(String artist) {
		return songRepo.findByArtistContaining(artist);
	}
	public List<Song> searchTopTen() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
}




