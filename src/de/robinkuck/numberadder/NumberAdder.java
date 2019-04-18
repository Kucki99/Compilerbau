package de.robinkuck.numberadder;

import de.robinkuck.filereader.FileReaderIntf;
import de.robinkuck.numberreader.NumberReader;

public class NumberAdder implements NumberAdderIntf {

    private FileReaderIntf fileReader;
    private NumberReader numberReader;

    public NumberAdder(FileReaderIntf fileReader) {
        this.fileReader = fileReader;
        numberReader = new NumberReader(fileReader);
    }

    @Override
    public int getSum() throws Exception {
        return expr();
    }

    public int expr() throws Exception {
        int sum = 0;
        sum += exprBegin();
        sum += exprAdd();
        return sum;
    }

    public int exprBegin() throws Exception {
        return numberReader.getNumber();
    }

    public int exprAdd() throws Exception {
        if (fileReader.lookAheadChar() == '+') {
            fileReader.advance();
            return expr();
        } else {
            fileReader.expect('\n');
            return 0;
        }
    }
}
