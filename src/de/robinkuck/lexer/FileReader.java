package de.robinkuck.lexer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReader implements FileReaderIntf {

    private InputStream inputStream;
    private Reader inputStreamReader;
    private String currentLine;
    private boolean endOfAfterCurrentLine;
    private int currentLineNextPos;
    private char nextChar;

    public FileReader(InputStream inputStream) {
        this.inputStream = inputStream;
        this.inputStreamReader = new InputStreamReader(inputStream);
        this.endOfAfterCurrentLine = false;
        this.currentLineNextPos = 0;
    }

    @Override
    public char lookAheadChar() {
        return nextChar;
    }

    @Override
    public void advance() throws Exception {
        while (currentLineNextPos == currentLine.length()) {
            if (endOfAfterCurrentLine) {
                nextChar = 0;
                return;
            } else {
                readNextLine();
                currentLineNextPos = 0;
            }
        }
        nextChar = currentLine.charAt(currentLineNextPos);
        currentLineNextPos++;
    }

    @Override
    public void expect(char c) throws Exception {
        if (nextChar != c) {
            String msg = "unexpected character: ";
            msg += nextChar;
            msg += "\nExpected: ";
            msg += c;
            msg += getCurrentLocationMsg();
            throw new Exception(msg);
        }
        advance();
    }

    public void expect(String s) throws Exception {
        for (int i = 0; i < s.length(); ++i) {
            if (nextChar != s.charAt(i)) {
                String msg = "unexpected character: ";
                msg += nextChar;
                msg += "\nExpected: ";
                msg += s.charAt(i);
                msg += getCurrentLocationMsg();
                throw new Exception(msg);
            }
        }
        advance();
    }

    @Override
    public String getCurrentLocationMsg() {
        String location = currentLine;
        for (int i = 1; i < currentLineNextPos; ++i) {
            location += ' ';
        }
        location += "^\n";
        return location;
    }

    private void readNextLine() throws Exception {
        currentLine = new String();
        while (true) {
            int nextChar = inputStreamReader.read();
            if (nextChar == -1) {
                currentLine += '\n';
                endOfAfterCurrentLine = true;
                return;
            } else if (nextChar == '\r') {
                continue;
            } else if (nextChar == '\n') {
                currentLine += '\n';
                return;
            } else {
                currentLine += (char) nextChar;
            }
        }
    }
}
