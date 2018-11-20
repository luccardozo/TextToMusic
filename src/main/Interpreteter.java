package main;

public class Interpreteter {
	//private final Character SILENCIO = ' ';
	private final Character EXCLAMACAO = '!';
	private final Character INTERROGACAO = '?';
	private final Character NEW_LINE = '\n';
	private final Character SEMICOLON = ';';
	private final Character COMMA = ',';
	//private final int SUCESS = 0;
	//private final int ERROR = -1;
	
	private Character charFromFile;
	private Character previousChar;
	//private MakeMusic music = new MakeMusic();
	private String lastRepresentation;
	private String noteRepresentation;
	
	public Character getCharFromFile() {
		return charFromFile;
	}

	public void setCharFromFile(Character charFromFile) {
		this.setPreviousChar(this.charFromFile);
		this.charFromFile = charFromFile;
	}
	
	
	public Character getPreviousChar() {
		return previousChar;
	}

	public void setPreviousChar(Character previousChar) {
		this.previousChar = previousChar;
	}

	public String Interpreter() {
		Character charFromFile = this.charFromFile;
		if(isNote(charFromFile)) {
			//noteRepresentation = music.charToNote(charFromFile);
			setLastRepresentation(noteRepresentation);
			return noteRepresentation;
		}
		if(Character.isDigit(charFromFile)) {
			if(isPar(charFromFile)) {
				//TODO: aumenta UMA oitava
				//noteRepresentation = music.IncreaseOctave();
				setLastRepresentation(noteRepresentation);
				return noteRepresentation;
			}
			else {
				//TODO: diminui UMA oitava
				//noteRepresentation = music.DecreaseOctave();
				setLastRepresentation(noteRepresentation);
				return noteRepresentation;
			}
		}
		if(isOtherVowel(charFromFile)) {
			//TODO: Diminui o volume pela metade
			//noteRepresentation = music.DecreaseVolumeByHalf();
			setLastRepresentation(noteRepresentation);
			return noteRepresentation;
		}
		if(isOtherConsonant(charFromFile)) {
			/*TODO: Se caractere anterior era
			* NOTA (A a G), repete nota;
			* Caso contrário, silêncio ou
			* pausa
			*/
			if(prevIsNote()) {
				setLastRepresentation(noteRepresentation);
				return noteRepresentation;
			}
			else {
				//noteRepresentation = music.Silence();
				setLastRepresentation(noteRepresentation);
				return noteRepresentation;
			}
		}
		if(charFromFile == EXCLAMACAO) {
			//TODO: Aumenta o volume para o dobro
			return "SUCESS";
		}
		if(charFromFile == INTERROGACAO) {
			//TODO: Volta a oitava default
			return "SUCESS";
		}
		if(charFromFile == NEW_LINE) {
			//TODO: Trocar o instrumento
			return "SUCESS";
		}
		if(charFromFile == SEMICOLON) {
			//TODO: aumenta BPM em 50
			return "SUCESS";
		}
		if(charFromFile == COMMA) {
			//TODO: diminui BPM em 50
			return "SUCESS";
		}
		//caracter desconhecido
		return "ERROR";
	}
	
	private boolean isNote(Character c) {
		switch(c) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case ' ':
			return true;
		default:
			return false;
			
		}
	}
	
	private boolean isPar(Character c){
	   int dig = c;
	   if(isPar(dig)) {
		   return true;
	   }
	   else
		   return false;
	}
	
	private boolean isPar(int dig) {
		if (dig % 2 == 0) {
			return true;
		}
		else
			return false;
	}
	
	private boolean isOtherVowel(Character c) {
		switch(c) {
		case 'I':
		case 'O':
		case 'U':
			return true;
		default:
			return false;
		}
	}
	//H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, and usually W and Y.
	private boolean isOtherConsonant(Character c) {
		switch (c) {
		case 'H':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'V':
		case 'X':
		case 'Z':
			return true;
		default:
			return false;
		}
	}
	
	private boolean prevIsNote() {
		if(isNote(this.previousChar)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getLastRepresentation() {
		return lastRepresentation;
	}

	public void setLastRepresentation(String lastRepresentation) {
		this.lastRepresentation = lastRepresentation;
	}

}
