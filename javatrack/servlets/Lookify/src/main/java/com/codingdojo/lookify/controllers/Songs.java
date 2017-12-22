package com.codingdojo.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;


@Controller
public class Songs {
	private final SongService songService;
	
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		System.out.println("in the new songs index");
		return "songs/new.jsp";
	}
	@RequestMapping(value="/newsongs", method=RequestMethod.POST)
	public String createSongs(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		System.out.println("in the add songs index");
		if (result.hasErrors()) {
			return "songs/new.jsp";
	    }else{
	    songService.addSong(song);
	        return "redirect:/dashboard";
	    }
	}
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
        return "redirect:/dashboard";
	}
}
