package de.robinkuck.lexer;

public class LexerManualMain {

    public static void main(String[] args) throws Exception {
        System.err.println("BEGIN");
        LexerTest test = new LexerTest("Lexer.txt");
        String s = test.executeTest("Lexer.txt");
        System.err.print(s);
        System.err.println("END");
    }

}
