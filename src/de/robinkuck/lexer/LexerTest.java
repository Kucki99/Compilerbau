package de.robinkuck.lexer;

import java.io.InputStream;

public class LexerTest extends TestBase {

	public LexerTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
        Lexer lexer = new Lexer(fileReader);
        Token currentToken;
        String output = new String();
        do {
        	currentToken = lexer.lookAheadToken();
        	output += currentToken.toString() + "\n";
        	lexer.advance();
        } while (currentToken.m_type != Token.Type.EOF);
		return output;
	}
}
