package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
	
	private String textString;
	private Character[] arrayCharacter;
	
	public String getTextoAsString() {
		return this.textString;
	}
	
	public void readFileAsString(String fileName) {
		String text = "";
		try {
			text = new String(Files.readAllBytes(Paths.get(fileName))); 
		} 
		catch (IOException e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace(); 
		} 
		this.textString = text.toUpperCase();
		convertStringToArrayChar();
	}
	
	private void convertStringToArrayChar() {
		this.arrayCharacter = this.textString.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	}
	
	public int lenghtArray() {
		return this.textString.length();
	}
	
	public char CharacterReturn(int place) {
		return this.arrayCharacter[place];
	}
	
}
