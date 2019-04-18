package de.robinkuck.numberreader;

import de.robinkuck.filereader.FileReaderIntf;

public class NumberReader implements NumberReaderIntf {

    private FileReaderIntf fileReader;

    public NumberReader(FileReaderIntf fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public int getNumber() throws Exception {
        int number = 0;
        char next = fileReader.lookAheadChar();
        if (!isDigit(next)) {
            throw new Exception("not a number");
        }
        do {
            fileReader.advance();
            number *= 10;
            number += (next - '0');
            next = fileReader.lookAheadChar();
        } while (isDigit(next));
        return number;
    }

    @Override
    public boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
