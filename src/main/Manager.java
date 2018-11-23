package main;

import org.jfugue.Player;

public class Manager {
	
	private Player player = new Player();
	private String Music;
	
	
	public void playMusic(String musicToPlay) {
		setMusic(musicToPlay);
		player.play(Music);
	}
	
	public void stopMusic() {
		player.stop();
	}
	
	public void puaseMusic() {
		player.pause();
	}


	public String getMusic() {
		return Music;
	}


	public void setMusic(String music) {
		Music = music;
	}

}
