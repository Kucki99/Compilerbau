package de.robinkuck.numberadder;

import de.robinkuck.filereader.FileReader;
import de.robinkuck.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberAdderTest extends TestBase {

	public NumberAdderTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberAdderIntf numberAdder = new NumberAdder(fileReader);
		int number = numberAdder.getSum();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}
