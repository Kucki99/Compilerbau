package de.robinkuck.statemachine;

public interface FileReaderIntf {
    // constructs FileReader reading from inputStream
    // public FileReader(InputStream inputStream) throws Exception;

    // look at the current character without
    // consuming it. 0 means EOF.
    public char lookAheadChar();

    // consume current char and
    // advance to next character
    public void advance() throws Exception;

    // check if next char is the expected character
    // throw Exception if not
    public void expect(char c) throws Exception;
}
