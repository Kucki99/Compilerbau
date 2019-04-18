package de.robinkuck.filereader;

import java.io.InputStream;

public class FileReader implements FileReaderIntf {

    char lookAheadChar = 0;
    InputStream inputStream;

    public FileReader(InputStream inputStream) throws Exception {
        this.inputStream = inputStream;
        advance();
    }

    @Override
    public char lookAheadChar() {
        return lookAheadChar;
    }

    @Override
    public void advance() throws Exception {
        int c = inputStream.read();
        lookAheadChar = (c == -1 ? 0 : (char) c);
    }

    @Override
    public void expect(char c) throws Exception {
        if (lookAheadChar != c) {
            throw new Exception("Unexpected character: " + lookAheadChar);
        }
    }

}
