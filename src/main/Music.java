package main;

public class Music {
	private int octave;
	private int instrument;
	private int bpm;
	private int volume;
	
	private final int MAX_VOLUME = 16383;
	private final int MAX_OCTAVE = 10;
	private final int MAX_INSTRUMENT = 127;
	
	private final int DEFAULT_OCTAVE = 0;
	private final int DEFAULT_INSTRUMENT = 0;
	private final int DEFAULT_BPM = 120;
	private final int DEFAULT_VOLUME = 4000;
	
	public Music() {
		octave = DEFAULT_OCTAVE;
		instrument = DEFAULT_INSTRUMENT;
		bpm = DEFAULT_BPM;
		volume = DEFAULT_VOLUME;
	}
	
	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		if(octave <= MAX_OCTAVE) {
			this.octave = octave;
		}
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		if(instrument <= MAX_INSTRUMENT) {
			this.instrument = instrument;
		}
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if(volume <= MAX_VOLUME) {
			this.volume = volume;
		}
	}

	public void increaseVolumeBy(double valor) {
		if (getVolume() == 0) {
			setVolume(1);
		} else if((getVolume() + (int)(getVolume()*valor)) < MAX_VOLUME) {
			setVolume(getVolume() + (int)(getVolume()*valor));
		}
	}
	
	
	public void halfVolume() {
		if(getVolume()/2 > 0) {
			setVolume(getVolume() / 2);
		}
	}
	
	public void increaseOctaveByOne() {
		if (octave < MAX_OCTAVE) {
			octave += 1;
		}
		else {
			octave = DEFAULT_OCTAVE;
		}
	}
	
	public void changeInstrument(int valor) {
		if ((getInstrument() + valor) <= MAX_INSTRUMENT) {
			setInstrument(getInstrument() + valor);
		}
	}

}
