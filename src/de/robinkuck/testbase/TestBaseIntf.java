package de.robinkuck.testbase;

import de.robinkuck.filereader.FileReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class TestBaseIntf {
    FileReader fileReader;

    // read and execute a sequence of test cases
    abstract void readAndExecuteTestSequence() throws Exception;

    // read and execute one test case
    abstract void readAndExecuteTestCase() throws Exception;

    // read the content of a test section (after $IN or $OUT)
    abstract String readTestContent() throws Exception;

    // check that input is $IN and consume it
    abstract void readDollarIn() throws Exception;

    // check that output is $OUT and consume it
    abstract void readDollarOut() throws Exception;

    // creates a Test object from an input file
    TestBaseIntf(String fileName) throws Exception {
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        fileReader = new FileReader(inputStream);
    }

    // execute a test case with the given input and compare result with expected output
    void executeTestCase(String input, String expectedOutput) throws Exception {
        String result;
        try {
            result = executeTest(input);
        } catch (Exception e) {
            result = "exception: \"";
            result += e.getMessage();
            result += "\"\n";
        }
        if (result.equals(expectedOutput)) {
            System.err.println("TEST SUCCEEDED");
            System.err.print(input);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
        } else {
            System.err.println("TEST FAILED");
            System.err.print(input);
            System.err.println("EXPECTED OUTPUT");
            System.err.print(expectedOutput);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
            throw new Exception("TestFailure");
        }
    }

    // test case implementation provided by concrete test class (not by test base)
    protected abstract String executeTest(String input) throws Exception;

    // public interface to execute all tests
    public void testRun() throws Exception {
        readAndExecuteTestSequence();
    }

    // helper method to create input stream from string
    public InputStream stringToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
