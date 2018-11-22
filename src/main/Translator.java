package main;

public class Translator {
	
	private final Character SPACE = ' ';
	private Character lastNote;
	private Character note;
	private String noteRepresentation;
	
	//static Vector <String> musica =  new Vector<String>();
	Music musica = new Music();
	
	Translator () {
		setNoteRepresentation(translateVolume() +" "+ translateInstrument()+" " + translateBPM()+" ");
	}
	
	public String getNoteRepresentation() {
		return noteRepresentation;
	}

	public void setNoteRepresentation(String noteRepresentation) {
		this.noteRepresentation = noteRepresentation;
	}
	
	public String charToNote(Character charFromFile) {
		this.setLastNote(this.getNote());
		this.setNote(charFromFile);
		setNoteRepresentation(charFromFile + translateOctave() + SPACE);
		return getNoteRepresentation();
	}
	
	private String translateInstrument() {
		return "I" + Integer.toString(musica.getInstrument());
	}
	
	private String translateVolume() {
		return "X[Volume]=" + Integer.toString(musica.getVolume());
	}
	
	private String translateOctave() {
		return Integer.toString(musica.getOctave());
	}
	
	private String translateBPM() {
		return "T"+Integer.toString(musica.getBpm());
	}

	public Character getLastNote() {
		return lastNote;
	}

	public void setLastNote(Character lastNote) {
		this.lastNote = lastNote;
	}

	public Character getNote() {
		return note;
	}

	public void setNote(Character note) {
		this.note = note;
	}

		
}
