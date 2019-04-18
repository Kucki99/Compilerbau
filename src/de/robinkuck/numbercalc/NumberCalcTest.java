package de.robinkuck.numbercalc;

import de.robinkuck.filereader.FileReader;
import de.robinkuck.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberCalcTest extends TestBase {

    public NumberCalcTest(String fileName) throws Exception {
        super(fileName);
    }

    public String executeTest(String input) throws Exception {
        InputStream inputStream = stringToInputStream(input);
        FileReaderIntf fileReader = new FileReader(inputStream);
        String output = new String();
        NumberCalcIntf numberCalc = new NumberCalc(fileReader);
        double number = numberCalc.getSum();
        output += Double.toString(number);
        output += '\n';
        return output;
    }
}
