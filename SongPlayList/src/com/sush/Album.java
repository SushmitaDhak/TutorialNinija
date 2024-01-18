package com.sush;

import java.util.ArrayList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String name, String artist, ArrayList<Song> songs) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	public Album() {
		
	}
	public Song findSong(String title ) {
		for(Song checkedSong : songs) {
			if (checkedSong.getTitle().equals(title))return checkedSong;
	}
		return null;
	}
	public boolean addSong(String title , double duration ) {
		if (findSong (title)== null) {
			songs.add(new Song(title,duration));
			System.out.println(title+"Successfully added to list");
			return true;
		}
		else {
			System.out.print("Song With Name "+ title +" aleady exist in the list");
			return false;
		}
	}
	

	

}
