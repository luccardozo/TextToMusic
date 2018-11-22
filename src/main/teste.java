package main;

public class teste {
	public static void main(String[] args) {
	
		Interpreteter interpretador = new Interpreteter("AAABBC");
		String saidaTest;
		
		saidaTest = interpretador.Interpreter();
		System.out.println(saidaTest);
	}
		
	
}
