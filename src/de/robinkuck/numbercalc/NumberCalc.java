package de.robinkuck.numbercalc;

import de.robinkuck.filereader.FileReaderIntf;
import de.robinkuck.numberreader.NumberReader;

public class NumberCalc implements NumberCalcIntf {

    private FileReaderIntf fileReader;
    private NumberReader numberReader;

    public NumberCalc(FileReaderIntf fileReader) {
        this.fileReader = fileReader;
        this.numberReader = new NumberReader(fileReader);
    }

    @Override
    public double getSum() throws Exception {
        double sum = 0;
        sum = getProduct();
        sum += getSum_();
        return sum;
    }

    public int getSum_() throws Exception {
        int sum = 0;
        while (fileReader.lookAheadChar() == '+' || fileReader.lookAheadChar() == '-') {
            fileReader.advance();
            if (fileReader.lookAheadChar() == '+') {
                sum += getProduct();
            } else {
                sum -= getProduct();
            }
        }
        return sum;
    }

    @Override
    public double getProduct() throws Exception {
        double product;
        product = getFactor();
        product *= getProduct_();
        return product;
    }

    public double getProduct_() throws Exception {
        double product = 1;
        while (fileReader.lookAheadChar() == '*' || fileReader.lookAheadChar() == '/') {
            if (fileReader.lookAheadChar() == '*') {
                fileReader.advance();
                product *= getProduct();
            } else {
                fileReader.advance();
                product /= getProduct();
            }
        }
        return product;
    }

    @Override
    public double getFactor() throws Exception {
        double factor = 0;
        // FACTOR ::= NUMBER | '(' EXPR ')'
        if (fileReader.lookAheadChar() == '(') {
            fileReader.advance();
            // consume expr
            factor = getSum();
            // consume ')'
            fileReader.expect(')');
            fileReader.advance();
        } else {
            factor = numberReader.getNumber();
        }
        return factor;
    }
}
