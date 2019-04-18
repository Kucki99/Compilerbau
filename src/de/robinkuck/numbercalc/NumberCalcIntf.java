package de.robinkuck.numbercalc;

public interface NumberCalcIntf {
	
    // creates a NumberCalc for a given FileReader
	// NumberAdderIntf(FileReaderIntf reader)
	
	// read sum
	double getSum() throws Exception;

	// read product
	double getProduct() throws Exception;
	
	// read factor
	double getFactor() throws Exception;

}
