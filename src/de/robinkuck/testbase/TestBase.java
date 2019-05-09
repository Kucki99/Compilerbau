package de.robinkuck.testbase;

public abstract class TestBase extends TestBaseIntf {

    public TestBase(String fileName) throws Exception {
        super(fileName);
    }

    @Override
    void readAndExecuteTestSequence() throws Exception {
        while (fileReader.lookAheadChar() != 0) {
            readAndExecuteTestCase();
        }
    }

    @Override
    void readAndExecuteTestCase() throws Exception {
        readDollarIn();
        String in = readTestContent();
        readDollarOut();
        String out = readTestContent();
        executeTestCase(in, out);
    }

    @Override
    String readTestContent() throws Exception {
        String result = "";
        while (fileReader.lookAheadChar() != '$' && fileReader.lookAheadChar() != 0) {
            result += fileReader.lookAheadChar();
            fileReader.advance();
        }
        return result;
    }

    @Override
    void readDollarIn() throws Exception {
        fileReader.expect('$');
        fileReader.expect('I');
        fileReader.expect('N');
        fileReader.expect('\r');
    }

    @Override
    void readDollarOut() throws Exception {
        fileReader.expect('$');
        fileReader.expect('O');
        fileReader.expect('U');
        fileReader.expect('T');
        fileReader.expect('\r');
    }

}
