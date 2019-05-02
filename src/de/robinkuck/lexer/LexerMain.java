package de.robinkuck.lexer;

public class LexerMain {

    public static void main(String[] args) throws Exception {
        System.err.println("BEGIN");
        LexerTest test = new LexerTest("Lexer.txt");
        test.testRun();
        System.err.println("END");
    }

}
