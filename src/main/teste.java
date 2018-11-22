package main;

public class teste {
	public static void main(String[] args) {
	
		Interpretador interpretador = new Interpretador("AAA2BBCopCp?AB;p!,\n");
		String saidaTest;
		
		saidaTest = interpretador.Interpreter();
		System.out.println(saidaTest);
	}
		
	
}
