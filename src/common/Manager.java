package common;

import java.io.File;
import java.io.IOException;


import org.jfugue.Player;

public class Manager extends Thread {
	
	private Player player = new Player();
	private String textToConvert = null;
	String textConverted = null;
	private static String Music;
	
	
	public void playMusic() {
		Builder builder = new Builder();
		builder.setTextToConvert(this.textToConvert);
		textConverted = builder.Interpreter();
		setMusic(textConverted);
		
		if(player.isPlaying() == false) {
			if(player.isPaused()) {
				player.resume();
			}
			else {
				System.out.println(Music);
				player.play(Music);
			}
		}
	}
	
	public void stopMusic() {
		if(player.isPlaying() || player.isPaused()) {
			player.stop();
		}
	}
	
	public void saveMIDI(File file) {
		Builder builder = new Builder();
		builder.setTextToConvert(this.textToConvert);
		String textConverted = builder.Interpreter();
		
		setMusic(textConverted);
		
		Player player = new Player();
		
		try {
			 player.saveMidi(textConverted, file);
			} 
		catch (IOException e)
			 {
			 System.out.println("Erro ao salvar o arquivo");
			 } 
	}

	
	public void pauseMusic() {
		if(player.isPlaying()) {
			player.pause();
		}
	}


	public String getMusic() {
		return Music;
	}


	public void setMusic(String music) {
		Music = music;
	}
	

	public String getTextToConvert() {
		return textToConvert;
	}

	public void setTextToConvert(String textToConvert) {
		this.textToConvert = textToConvert;
	}
	
	public void run() {
		playMusic();
	}
}
