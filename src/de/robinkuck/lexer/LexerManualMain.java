package de.robinkuck.lexer;

public class LexerManualMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		LexerTest test = new LexerTest();
		String s = test.executeTest(args[0]);
		System.err.print(s);
		System.err.println("END");
	}

}
