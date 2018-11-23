package main;

public class teste {
	public static void main(String[] args) {
	
		Manager player = new Manager();
		Interpretador interpretador = new Interpretador("AAA2BBCopCp?A?A?A?A?A?A?A?A?A?  oooAB;p!,\nAAABBB");
		String saidaTest;
		
		saidaTest = interpretador.Interpreter();
		System.out.println(saidaTest);
		player.playMusic(saidaTest);
	}
		
	
}
