package main;

public class Interpretador {

	private final Character EXCLAMACAO = '!'; //Trocar instrumento para o instrumento General MIDI #7 (Harpsichord) 
	private final Character INTERROGACAO = '?';//Aumenta UMA oitava; Se não puder, aumentar, volta à oitava default (de início)
	private final Character NEW_LINE = '\n';//Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells) 
	private final Character SEMICOLON = ';'; //Trocar instrumento para o instrumento General MIDI #76 (Pan Flute) 
	private final Character COMMA = ','; //Trocar instrumento para o instrumento General MIDI #20 (Church Organ)
	private final Character SPACE = ' ';//Aumenta volume para o DOBRO do volume
	private final Character SILENCE = 'R';
	
	private final double TEN_PERCENT = 0.10;
	private final double HALF_PERCENT = 0.50;
	private final int HARPSICHORD = 6;
	private final int TUBULAR_BELLS = 14;
	private final int PAN_FLUTE = 75;
	private final int CHURCH_ORGAN = 19;
	
	private Character currentChar;
	private Character previousChar;
	
	private String ConvertedText;
	private String textToConvert;
	
	private Builder builder = new Builder();
	
	
	Interpretador (String textToConvert){
		this.ConvertedText = builder.getNoteRepresentation();
		this.textToConvert = textToConvert;
		this.previousChar = ' ';
	}
	
	public Character getCurrentChar() {
		return currentChar;
	}

	public void setCurrentChar(Character charToTranslate) {
		this.setPreviousChar(this.currentChar);
		this.currentChar = charToTranslate;
	}
	
	
	public Character getPreviousChar() {
		return previousChar;
	}

	public void setPreviousChar(Character previousChar) {
		this.previousChar = previousChar;
	}
/*Interpretador*/
	public String Interpreter() {
		for(int i = 0; i < textToConvert.length(); i++) {
			
			setCurrentChar(textToConvert.charAt(i));
			
			if(isNote(this.currentChar)) {
				ConvertedText += builder.charToNote(this.currentChar);
				setPreviousChar(this.currentChar);
			}
			
			if(Character.isDigit(this.currentChar)) {
				ConvertedText += builder.changeInstrumentByOne(Character.getNumericValue(this.currentChar));
				setPreviousChar(this.currentChar);
			}
			
			if(isOtherVowel(this.currentChar) && !isNote(this.currentChar)) {
				ConvertedText += builder.increaseVolumeBy(TEN_PERCENT);
				setPreviousChar(this.currentChar);
			}
			
			if(isOtherConsonant(this.currentChar) && !isNote(this.currentChar)) {
				if(prevIsNote()) {
					ConvertedText += builder.charToNote(this.previousChar);
					setPreviousChar(this.currentChar);
				}
				else {
					ConvertedText +=builder.charToNote(SILENCE);
					setPreviousChar(this.currentChar);
				}
			}
			
			if(this.currentChar == EXCLAMACAO) {
				ConvertedText += builder.changeInstrumetTo(HARPSICHORD);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == INTERROGACAO) {
				ConvertedText += builder.increaseOctave();
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == NEW_LINE) {
				ConvertedText += builder.changeInstrumetTo(TUBULAR_BELLS);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == SEMICOLON) {
				ConvertedText += builder.changeInstrumetTo(PAN_FLUTE);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == COMMA) {
				ConvertedText += builder.changeInstrumetTo(CHURCH_ORGAN);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == SPACE) {
				ConvertedText += builder.increaseVolumeBy(HALF_PERCENT);
				setPreviousChar(this.currentChar);
			}
			if(isOtherCharacter()) {
				if(prevIsNote()) {
					ConvertedText += builder.charToNote(this.previousChar);
					setPreviousChar(this.currentChar);
				}
				else {
					ConvertedText +=builder.charToNote(SILENCE);
					setPreviousChar(this.currentChar);
				}
			}
		}
		return ConvertedText;
	}
	
	//só é nota se for maiuscula
	private boolean isNote(Character c) {
		switch(c) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
			return true;
		default:
			return false;
			
		}
	}
		
	private boolean isOtherVowel(Character c) {
		c = Character.toUpperCase(c);
		switch(c) {
		case 'I':
		case 'O':
		case 'U':
		case 'A':
		case 'E':	
			return true;
		default:
			return false;
		}
	}
//H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, and usually W and Y.
	private boolean isOtherConsonant(Character c) {
		c = Character.toUpperCase(c);
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
		case 'B':
		case 'C':
		case 'D':
		case 'F':
		case 'G':
		case ' ':
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
	
	private boolean isOtherCharacter() {
		return !(this.currentChar == SPACE)
				&& !(this.currentChar == COMMA)
				&& !(this.currentChar == SEMICOLON)
				&& !(this.currentChar == NEW_LINE)
				&& !(this.currentChar == INTERROGACAO)
				&& !(this.currentChar == EXCLAMACAO)
				&& !isOtherConsonant(this.currentChar)
				&& !isNote(this.currentChar)
				&& !Character.isDigit(this.currentChar);
	}

}
