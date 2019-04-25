package de.robinkuck.lexer;

public class Lexer implements LexerIntf {

    private FileReaderIntf fileReader;

    public Lexer(FileReaderIntf fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public Token lookAheadToken() {
        return null;
    }

    @Override
    public void advance() throws Exception {

    }

    @Override
    public void expect(Token.Type tokenType) throws Exception {

    }

    @Override
    public Token.Type getTokenType(char firstChar) throws Exception {
        return null;
    }

    @Override
    public String getIdent() throws Exception {
        return null;
    }

    @Override
    public boolean isIdentifierPart(char c) {
        return false;
    }

    @Override
    public int getNumber() throws Exception {
        return 0;
    }

    @Override
    public boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    @Override
    public boolean isWhiteSpace(char c) {
        return Character.isWhitespace(c);
    }
}
