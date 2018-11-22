package main;

public class Builder {
	
	private final String SPACE = " ";
	
	private String noteRepresentation;
	
	Music musica = new Music();
	Translator translate = new Translator();
	
	Builder () {
		setDefaultNoteRepresentation();
	}

	private void setDefaultNoteRepresentation() {
		setNoteRepresentation(volumeRepresentation()+ SPACE +instrumentRepresentation()+ SPACE +bpmRepresentation() + SPACE);
	}

	
	public String getNoteRepresentation() {
		return noteRepresentation;
	}
	
	public void setNoteRepresentation(String noteRepresentation) {
		this.noteRepresentation = noteRepresentation;
	}
	
	public String charToNote(Character charToRepresent) {
		setNoteRepresentation(charToRepresent + octaveRepresentation() + SPACE);
		return getNoteRepresentation();
	}


	public String changeInstrumentByOne(int charInInt) {
		musica.changeInstrument(charInInt);
		setNoteRepresentation(instrumentRepresentation() + SPACE);
		return getNoteRepresentation();
	}
	
	public String changeInstrumetTo(int instrumentValue) {
		musica.setInstrument(instrumentValue);
		setNoteRepresentation(instrumentRepresentation() + SPACE);
		return getNoteRepresentation();
	}
	
	public String increaseVolumeBy(double volume) {
		musica.increaseVolumeBy(volume);
		setNoteRepresentation(volumeRepresentation() + SPACE);
		return getNoteRepresentation();
	}
	
	public String increaseOctave() {
		musica.increaseOctaveByOne();
		setNoteRepresentation(SPACE);
		return getNoteRepresentation();
	}

	
	private String octaveRepresentation() {
		return translate.Octave(musica.getOctave());
	}
	
	private String bpmRepresentation() {
		return translate.BPM(musica.getBpm());
	}

	private String instrumentRepresentation() {
		return translate.Instrument(musica.getInstrument());
	}

	private String volumeRepresentation() {
		return translate.Volume(musica.getVolume());
	}

}
