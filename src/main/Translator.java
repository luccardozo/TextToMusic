package main;

public class Translator {
	
	public String Instrument(int Instrument) {
		return "I" + Integer.toString(Instrument);
	}
	
	public String Volume(int Volume) {
		return "X[Volume]=" + Integer.toString(Volume);
	}
	
	public String Octave(int Octave) {
		return Integer.toString(Octave);
	}
	
	public String BPM(int BPM) {
		return "T"+Integer.toString(BPM);
	}
}
