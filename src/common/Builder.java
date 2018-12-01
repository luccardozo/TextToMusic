package common;

public class Builder {

	private final Character EXCLAMATION_MARK = '!'; //Trocar instrumento para o instrumento General MIDI #7 (Harpsichord) 
	private final Character QUESTION_MARK = '?';//Aumenta UMA oitava; Se não puder, aumentar, volta à oitava default (de início)
	private final Character POINT = '.';
	private final Character NEW_LINE = '\n';//Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells) 
	private final Character SEMICOLON = ';'; //Trocar instrumento para o instrumento General MIDI #76 (Pan Flute) 
	private final Character COMMA = ','; //Trocar instrumento para o instrumento General MIDI #20 (Church Organ)
	private final Character SPACE = ' ';//Aumenta volume para o DOBRO do volume
	private final Character SILENCE = 'R';
	
	private final double TEN_PERCENT = 0.10;
	private final double FULL_PERCENT = 1.0;
	private final int HARPSICHORD = 6;
	private final int TUBULAR_BELLS = 14;
	private final int PAN_FLUTE = 75;
	private final int CHURCH_ORGAN = 19;
	
	private Character currentChar;
	private Character previousChar;
	
	private String ConvertedText = null;
	private String textToConvert = null;
	
	private Converter converter = new Converter();
	
	
	public Builder (){
		this.ConvertedText = converter.getNoteRepresentation();
		this.previousChar = ' ';
	}
//sets \ gets	
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
	
	public String getTextToConvert() {
		return textToConvert;
	}
	
	public void setTextToConvert(String textToConvert) {
		this.textToConvert = textToConvert;
	}
	
/*Interpretador*/
	public String Interpreter() {
		for(int i = 0; i < getTextToConvert().length(); i++) {
			setCurrentChar(getTextToConvert().charAt(i));
			
			if(isNote(this.currentChar)) {
				ConvertedText += converter.charToNote(this.currentChar);
				setPreviousChar(this.currentChar);
			}
			
			if(Character.isDigit(this.currentChar)) {
				ConvertedText += converter.changeInstrumentByOne(Character.getNumericValue(this.currentChar));
				setPreviousChar(this.currentChar);
			}
			
			if(isOtherVowel(this.currentChar) && !isNote(this.currentChar)) {
				ConvertedText += converter.increaseVolumeBy(TEN_PERCENT);
				setPreviousChar(this.currentChar);
			}
			
			if(isOtherConsonant(this.currentChar) && !isNote(this.currentChar)) {
				if(prevIsNote()) {
					ConvertedText += converter.charToNote(this.previousChar);
					setPreviousChar(this.currentChar);
				}
				else {
					ConvertedText +=converter.charToSilence(SILENCE);
					setPreviousChar(this.currentChar);
				}
			}
			
			if(this.currentChar == EXCLAMATION_MARK) {
				ConvertedText += converter.changeInstrumetTo(HARPSICHORD);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == QUESTION_MARK || this.currentChar == POINT) {
				ConvertedText += converter.increaseOctave();
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == NEW_LINE) {
				ConvertedText += converter.changeInstrumetTo(TUBULAR_BELLS);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == SEMICOLON) {
				ConvertedText += converter.changeInstrumetTo(PAN_FLUTE);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == COMMA) {
				ConvertedText += converter.changeInstrumetTo(CHURCH_ORGAN);
				setPreviousChar(this.currentChar);
			}
			
			if(this.currentChar == SPACE) {
				ConvertedText += converter.increaseVolumeBy(FULL_PERCENT);
				setPreviousChar(this.currentChar);
			}
			if(isOtherCharacter()) {
				if(prevIsNote()) {
					ConvertedText += converter.charToNote(this.previousChar);
					setPreviousChar(this.currentChar);
				}
				else {
					ConvertedText +=converter.charToSilence(SILENCE);
					setPreviousChar(this.currentChar);
				}
			}
		}
		return ConvertedText;
	}
	
//booleanos	
	//só é nota se for maiuscula
	private boolean isNote(Character c) {
		if(c != null) {
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
		else
			return false;
	}
		
	private boolean isOtherVowel(Character c) {
		if(c != null) {
			c = Character.toUpperCase(c);
			switch(c) {
			case 'I':
			case 'O':
			case 'U':	
				return true;
			default:
				return false;
			}
		}
		else
			return false;
	}
//H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, and usually W and Y.
	private boolean isOtherConsonant(Character c) {
		if (c != null) {
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
			case 'W':
				return true;
			default:
				return false;
			}
		}
		else
			return false;
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
				&& !(this.currentChar == QUESTION_MARK)
				&& !(this.currentChar == POINT)
				&& !(this.currentChar == EXCLAMATION_MARK)
				&& !isOtherConsonant(this.currentChar)
				&& !isNote(this.currentChar)
				&& !Character.isDigit(this.currentChar)
				&& !isOtherVowel(this.currentChar);
	}

}
